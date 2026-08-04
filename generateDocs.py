#!/usr/bin/env python3
"""Generate repository and session documentation for Java practicals."""

from __future__ import annotations

import argparse
import datetime as dt
import os
import re
import shutil
import subprocess
import sys
import tempfile
from dataclasses import dataclass
from pathlib import Path
DATE_PATTERN = re.compile(r"^(\d{2})-(\d{2})-(\d{4})$")
GENERATED_MARKER = ""


@dataclass
class Program:
    source: Path
    stem: str
    title: str
    code: str
    output: str
    status: str


@dataclass
class Session:
    folder: Path
    date: dt.date
    programs: list[Program]


def title_from_stem(stem: str) -> str:
    value = re.sub(r"[_-]+", " ", stem)
    value = re.sub(r"(?<=[a-z0-9])(?=[A-Z])", " ", value)
    value = re.sub(r"(?<=[A-Z])(?=[A-Z][a-z])", " ", value)
    return value.title()


def display_date(value: dt.date) -> str:
    return value.strftime("%B %-d, %Y") if os.name != "nt" else value.strftime("%B %#d, %Y")


def discover_sessions(root: Path) -> list[Path]:
    sessions = []
    for child in root.iterdir():
        if not child.is_dir() or not DATE_PATTERN.fullmatch(child.name):
            continue
        month, day, year = (int(part) for part in child.name.split("-"))
        try:
            dt.date(year, month, day)
        except ValueError:
            continue
        sessions.append(child)
    return sorted(sessions, key=lambda path: dt.datetime.strptime(path.name, "%m-%d-%Y").date(), reverse=True)


def run_program(source: Path, root: Path) -> tuple[str, str]:
    javac = shutil.which("javac")
    java = shutil.which("java")
    if not javac or not java:
        return "Output unavailable: Java compiler/runtime was not found.", "toolchain unavailable"

    with tempfile.TemporaryDirectory(prefix="java-docs-") as build_dir:
        build_path = Path(build_dir)
        compile_result = subprocess.run(
            [javac, "-encoding", "UTF-8", "-d", str(build_path), str(source)],
            cwd=root,
            capture_output=True,
            text=True,
            timeout=20,
            check=False,
        )
        if compile_result.returncode != 0:
            details = compile_result.stderr.strip() or "compilation failed"
            return f"Output unavailable: {details}", "compilation failed"

        try:
            execution = subprocess.run(
                [java, "-cp", str(build_path), source.stem],
                cwd=root,
                capture_output=True,
                text=True,
                timeout=5,
                check=False,
            )
        except subprocess.TimeoutExpired:
            return "Output unavailable: program exceeded the 5-second execution limit.", "execution timed out"

        if execution.returncode != 0:
            details = execution.stderr.strip() or f"program exited with status {execution.returncode}"
            return f"Output unavailable: {details}", "execution failed"
        return execution.stdout.rstrip("\n"), "captured by compiling and running the source"


def load_sessions(root: Path) -> list[Session]:
    sessions = []
    for folder in discover_sessions(root):
        date = dt.datetime.strptime(folder.name, "%m-%d-%Y").date()
        programs = []
        for source in sorted(folder.glob("*.java"), key=lambda path: path.name.lower()):
            output, status = run_program(source, root)
            programs.append(
                Program(
                    source=source,
                    stem=source.stem,
                    title=title_from_stem(source.stem),
                    code=source.read_text(encoding="utf-8"),
                    output=output,
                    status=status,
                )
            )
        sessions.append(Session(folder=folder, date=date, programs=programs))
    return sessions


def fenced_code(value: str, language: str) -> str:
    return f"```{language}\n{value.rstrip()}\n```"


def session_readme(session: Session) -> str:
    lines = [f"# Programming Exercises - {display_date(session.date)}", ""]
    for index, program in enumerate(session.programs, start=1):
        lines.extend(
            [
                f"## Exercise {index}: {program.title}",
                "",
                "### Code",
                "",
                fenced_code(program.code, "java"),
                "",
                "### Output",
                "",
                fenced_code(program.output, "text"),
                "",
            ]
        )
    if not session.programs:
        lines.extend(["No Java programs were found in this session.", ""])
    return "\n".join(lines)


def github_repository(root: Path) -> str:
    try:
        remote = subprocess.run(
            ["git", "-C", str(root), "config", "--get", "remote.origin.url"],
            capture_output=True,
            text=True,
            check=False,
        ).stdout.strip()
    except OSError:
        remote = ""
    if remote.startswith("git@github.com:"):
        remote = remote.removeprefix("git@github.com:")
    remote = remote.removesuffix(".git").rstrip("/")
    if remote.startswith("https://github.com/"):
        return remote
    if "/" in remote and not remote.startswith(("http://", "https://")):
        return f"https://github.com/{remote}"
    return ""


def pages_url(repository: str) -> str:
    match = re.search(r"github\.com/([^/]+)/([^/]+)$", repository)
    if not match:
        return ""
    return f"https://{match.group(1).lower()}.github.io/{match.group(2)}/"


def pdf_entries(root: Path, category: str) -> list[Path]:
    candidates = [root / category, root / "pdfs" / category.lower(), root / "pdfs" / category.capitalize()]
    found = set()
    for directory in candidates:
        if directory.is_dir():
            found.update(path for path in directory.glob("*.pdf") if path.is_file())
    return sorted(found, key=lambda path: path.name.lower())


def pdf_section(root: Path, repository: str, category: str, heading: str) -> list[str]:
    entries = pdf_entries(root, category)
    lines = [f"### {heading}", "", "| PDF | Open |", "|-----|------|"]
    if not entries:
        lines.append("| _No reference PDFs yet_ | — |")
        return lines + [""]
    for pdf in entries:
        relative = pdf.relative_to(root).as_posix()
        lines.append(f"| {pdf.name} | [Open PDF](./{relative}) |")
    return lines + [""]


def root_readme(root: Path, sessions: list[Session]) -> str:
    repository = github_repository(root)
    pages = pages_url(repository)
    program_count = sum(len(session.programs) for session in sessions)
    pdf_count = len(pdf_entries(root, "Notes"))
    lines = [
        "# Java Programs",
        "",
        "> A collection of Java programs completed during practical classes.",
        "",
        "## At A Glance",
        "",
        f"- **{len(sessions)}** practical session{'s' if len(sessions) != 1 else ''}",
        f"- **{program_count}** program{'s' if program_count != 1 else ''}",
        f"- **{pdf_count}** reference PDF{'s' if pdf_count != 1 else ''}",
        f"- [Browse the programs online]({pages or './docs'})",
        "",
        "## Practical Sessions",
        "",
        "| Date | Programs | Open |",
        "|------|----------|------|",
    ]
    for session in sessions:
        topics = ", ".join(program.title for program in session.programs) or "—"
        docs_link = f"{pages}exercises/{session.folder.name}" if pages else f"./docs/exercises/{session.folder.name}"
        lines.append(
            f"| {display_date(session.date)} | {topics} ({len(session.programs)}) | [View session]({docs_link}) |"
        )
    if not sessions:
        lines.append("| _None tracked_ | — | [No sessions yet](./docs) |")
    lines.extend(["", "## Reference PDFs", ""])
    lines.extend(pdf_section(root, repository, "Notes", "Notes"))
    return "\n".join(lines)


def docs_index(root: Path, sessions: list[Session]) -> str:
    program_count = sum(len(session.programs) for session in sessions)
    lines = [
        "# Java Programs",
        "",
        "> A searchable reference for college practical class programs.",
        "",
        f"There are **{program_count}** programs from **{len(sessions)}** practical session{'s' if len(sessions) != 1 else ''}.",
        "",
        "## Practical Sessions",
        "",
        "| Date | Programs |",
        "|------|----------|",
    ]
    for session in sessions:
        topics = ", ".join(program.title for program in session.programs) or "—"
        lines.append(f"| [{display_date(session.date)}](exercises/{session.folder.name}.md) | {topics} |")
    if not sessions:
        lines.append("| _No sessions yet_ | — |")
    return "\n".join(lines)


def docs_session(session: Session) -> str:
    lines = [f"# {display_date(session.date)}", "", "The programs completed during this practical session.", ""]
    for index, program in enumerate(session.programs, start=1):
        lines.extend(
            [
                f"## {index}. {program.title}",
                "",
                fenced_code(program.code, "java"),
                "",
                "**Sample output**",
                "",
                fenced_code(program.output, "text"),
                "",
            ]
        )
    return "\n".join(lines)


def generated_files(root: Path, sessions: list[Session]) -> dict[Path, str]:
    files = {
        root / "README.md": root_readme(root, sessions),
        root / "docs" / "index.md": docs_index(root, sessions),
    }
    for session in sessions:
        files[session.folder / "README.md"] = session_readme(session)
        files[root / "docs" / "exercises" / f"{session.folder.name}.md"] = docs_session(session)
    return files


def write_files(files: dict[Path, str]) -> None:
    for path, content in files.items():
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(content.rstrip() + "\n", encoding="utf-8")


def check_files(files: dict[Path, str]) -> bool:
    stale = False
    for path, content in files.items():
        expected = content.rstrip() + "\n"
        actual = path.read_text(encoding="utf-8") if path.exists() else None
        if actual != expected:
            print(f"stale: {path}")
            stale = True
    return not stale


def main() -> int:
    parser = argparse.ArgumentParser(description="Generate Java repository documentation.")
    parser.add_argument("--root", type=Path, default=Path(__file__).resolve().parent)
    parser.add_argument("--check", action="store_true", help="check generated files without writing them")
    args = parser.parse_args()
    root = args.root.resolve()
    sessions = load_sessions(root)
    files = generated_files(root, sessions)
    if args.check:
        return 0 if check_files(files) else 1
    write_files(files)
    print(f"Generated {len(files)} documentation files for {len(sessions)} session(s).")
    return 0


if __name__ == "__main__":
    sys.exit(main())

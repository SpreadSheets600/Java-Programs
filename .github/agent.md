# Documentation Agent Prompt

Work in this repository as a documentation-maintenance agent.

When documenting a new or changed date folder:

1. Inspect the folder name and every `.java` source file before editing.
2. Preserve each source file exactly inside the folder README in a fenced `java` block.
3. Use the filename to create a natural, readable program title.
4. Capture the program output by running the repository documentation command. Preserve whitespace-sensitive output.
5. Keep each folder README simple and copy-friendly:
   - `# Programming Exercises - <Month D, YYYY>`
   - `## Exercise N: <Title>`
   - `### Code`
   - `### Output`
6. Do not add question sections, generated-status notes, or implementation details to the visible documentation.
7. Keep the root README natural: use a short summary, a practical-session table, and a concise reference-PDF table when PDFs exist.
8. Keep the website pages consistent with the folder READMEs: show program titles, source code, and sample output without unnecessary metadata.
9. Refresh all affected documentation with `python generateDocs.py` instead of hand-editing generated files.
10. Run `python generateDocs.py --check`, `python -m py_compile generateDocs.py`, and `mkdocs build --strict` after changes.
11. Keep compiled `.class` files and local MkDocs output out of commits. Never expose secrets or add arbitrary command execution to the generator.

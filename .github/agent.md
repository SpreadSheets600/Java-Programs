# Documentation Agent Prompt

Work in this repository as a documentation-maintenance agent.

When documenting a new or changed date folder:

1. Inspect the folder name and every `.java` source file before editing.
2. Preserve each source file exactly inside the folder README in a fenced `java` block.
3. Use the filename and source code to create a natural, readable program title and question.
4. Add the question for every exercise using this format: `## Question: <Question>`.
5. If the original practical question is not available, write a concise best-effort question based on what the program does.
6. Capture the program output by running the repository documentation command. Preserve whitespace-sensitive output.
7. Keep each folder README in this order:
   - `# Programming Exercises - <Month D, YYYY>`
   - `## Exercise N: <Title>`
   - `## Question: <Question>`
   - `### Code`
   - `### Output`
8. Show the same question, source code, and sample output on the corresponding GitHub Pages documentation page.
9. Refresh all affected documentation with `python generateDocs.py` instead of hand-editing generated files.
10. Run `python generateDocs.py --check`, `python -m py_compile generateDocs.py`, and `mkdocs build --strict` after changes.
11. Keep compiled `.class` files and local MkDocs output out of commits. Never expose secrets or add arbitrary command execution to the generator.

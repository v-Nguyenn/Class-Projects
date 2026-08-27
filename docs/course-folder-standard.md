# Course Folder Standard

Use this standard for each course directory while preserving class-specific naming and content.

## Recommended Layout

```text
course-name/
  README.md
  learning-objectives.md
  assignments/
    assignment-01/
    assignment-02/
  labs/
    lab-01/
    lab-02/
  projects/
  notes/
  resources/
```

## Naming Rules

- Course root: `subject-courseNumber-section` (example: `cecs-277-sec8`).
- Prefer lowercase and hyphens for standardized folders.
- Keep existing names if renaming would break class references.

## File Conventions

- Course-level README should include:
  - course name and term
  - folder map
  - run instructions
  - grading or submission notes (optional)
- Learning objectives file should use a consistent heading format.
- Keep starter code and instructor-provided files unchanged.

## Practical Compromise

To preserve class context while standardizing:

- Keep current course root names.
- Add standardized subfolders only when you touch that course again.
- Document exceptions in each course README instead of forcing full renames.

## Run Commands Section Template

```md
## How To Run

### Python

`py main.py`

### C++

`g++ file.cpp -o file.exe` then `.\\file.exe`

### Java

`javac Main.java` then `java Main`
```

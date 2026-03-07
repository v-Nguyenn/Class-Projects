# Programming Course Files

This repository contains coursework organized by class. The goal is to keep school-specific context while using a consistent, GitHub-friendly structure.

## Repository Goals

- Keep all original class materials and assignment context.
- Standardize folder names and documentation style.
- Make it easy to find, run, and review projects.
- Avoid committing generated files and local machine metadata.

## Current Course Folders

### Classes taken at California State University, Long Beach

- `cecs-229-sec1/` (Discrete Structures with Computing Applications 2)
- `cecs-277-sec8/` (Object Oriented Programming)
- `cecs-325-sec1/` ( )
- `cecs-328/` (Algorithms)

### CLasses taken at Irvine Valley College

- `cs-10-intro-to-python/`
- `cs-38-java/`
- `cs-41-data-structures/`

## How To Run Programs

### Python

From a course assignment or lab folder:

```powershell
py main.py
```

If there is no `main.py`, run the specific file:

```powershell
py lab3.py
```

### C++

Compile then run:

```powershell
g++ Arrays.cpp -o Arrays.exe
.\Arrays.exe
```

### Java

Compile then run:

```powershell
javac Main.java
java Main
```

## Standardization Docs

- Folder conventions: `docs/course-folder-standard.md`
- Phased migration plan: `docs/repo-refactor-plan.md` (gitignore)

## Notes

- Some older files from CS-10 and CS-41 are missing due to a laptop replacement (Fall 2021).
- Refactor is intentionally non-destructive: existing coursework paths remain valid.

## Notes

- Some older files from CS-10 and CS-41 are missing due to a laptop replacement (Fall 2021).
- Refactor is intentionally non-destructive: existing coursework paths remain valid.

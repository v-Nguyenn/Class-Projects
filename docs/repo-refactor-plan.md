# Repo Refactor Plan

This plan standardizes the repository without losing class-specific structure.

## Phase 1: Documentation First (Safe)

- Improve root `README.md` with clear navigation and run instructions.
- Add course folder standards and naming guidelines.
- Keep all existing coursework paths untouched.

Status: complete.

## Phase 2: Standardize Per Course (Incremental)

For one course at a time:

1. Add/update course `README.md`.
2. Add a `How To Run` section.
3. Group future work into `assignments/`, `labs/`, and `projects/` when reasonable.
4. Keep legacy folders as-is if they are referenced in submissions.

## Phase 3: Optional Renaming (Only If Needed)

- Optionally rename folders like `Assignment1` to `assignment-01`.
- Do this only between terms or after grading is finalized.
- Use small commits and verify paths before pushing.

## Phase 4: Hygiene

- Keep `.gitignore` focused on generated files.
- Remove stale caches or local metadata from tracking.
- Maintain one style for README files across courses.

## Suggested Commit Strategy

Use small, reversible commits:

1. `docs: standardize root readme and repo guide`
2. `docs(cecs-277): add course readme run instructions`
3. `refactor(cecs-229): normalize assignment folder names` (optional)

## Success Criteria

- New visitor can find any class quickly.
- Each course has clear run instructions.
- No breaking path changes for active coursework.
- Repository looks consistent on GitHub.

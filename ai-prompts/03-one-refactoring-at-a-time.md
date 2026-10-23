# Prompt: apply exactly one refactoring

**Use it for:** step 5 of the AI-assisted workflow (Chapter 8) — small, reviewable, behaviour-preserving changes.

```text
Apply one refactoring only: Extract Method on the validation block in
<ClassName>.<methodName>(). Do not change behaviour, public signatures or
tests. Run the test suite and show me the result before and after.
```

## Tips

- One refactoring per change keeps each diff small enough to review properly.
- If the assistant edits a test to make the build pass, reject the change.
- Watch for the subtle faults AI refactorings introduce: added input checks, changed numeric constants, and reordered arithmetic.

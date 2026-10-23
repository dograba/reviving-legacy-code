# Prompt: write characterisation tests

**Use it for:** step 3 of the AI-assisted workflow (Chapter 8) — pinning down current behaviour before refactoring.

```text
Write characterisation tests for <ClassName> that pin down its CURRENT
behaviour, including edge cases (zero, negative, very large values, nulls,
empty collections). Do not change <ClassName>. If current behaviour looks
like a bug, keep the test asserting today's behaviour and add a comment
flagging it.
```

## Tips

- Run the generated tests against the **unmodified** code and commit them before any refactoring starts.
- Review every assertion: generated tests lock in current behaviour, bugs included.
- See `java/src/test/java/com/revivinglegacycode/characterisation/` for a worked example, including a golden master test.

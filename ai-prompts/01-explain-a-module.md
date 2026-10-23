# Prompt: explain a legacy module

**Use it for:** step 1 of the AI-assisted workflow (Chapter 8) — understanding code before you change it.

**Works with:** any agentic coding assistant that can read your repository.

```text
Explain what <ClassOrModuleName> does. List every input, output, side effect
(database writes, files, queues, external calls) and business rule, with the
line numbers each rule comes from. Flag anything you are unsure about rather
than guessing.
```

## Tips

- Ask for line numbers so you can check every claim against the code.
- Have someone who knows the system review the explanation before you rely on it.
- Save the reviewed result next to the code — it pays down documentation debt immediately.

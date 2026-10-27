# Reviving Legacy Code — companion code

Runnable code samples, worked examples and AI prompts for the book **[Reviving Legacy Code](https://www.amazon.co.uk/dp/B0C4J331MX)** by Baljeet Dogra.

Every refactoring here ships with tests that prove it did not change behaviour. That is the core idea of the book: get legacy code under test, change it in small steps, and let the tests tell you whether you broke anything.

## What's here

| Folder | Book chapter | What it shows |
| --- | --- | --- |
| [`java/`](java/) | 3 and 7 | **Characterisation tests and a golden master** for an untested legacy class, plus **Replace Conditional with Polymorphism** with an equivalence test |
| [`csharp/`](csharp/) | 7 | **Single Responsibility Principle**: separating area calculations from a UI-coupled class, with tests that characterise the legacy output first |
| [`python/`](python/) | 7 | **Extract Function** and a generator expression, with before/after equivalence tests |
| [`cpp/`](cpp/) | 7 | **Templates** replacing duplicated overloads, with equivalence checks |
| [`ai-prompts/`](ai-prompts/) | 8 | Copy-paste prompts for using AI coding assistants safely on legacy code |
| [`REFERENCES.md`](REFERENCES.md) | All | Clickable list of every source cited in the book |
| [`ERRATA.md`](ERRATA.md) | — | Corrections to the 1st edition |

Each sample keeps the **before** and **after** versions side by side so you can compare them.

## Running the samples

| Language | Requirements | Command (run from the folder) |
| --- | --- | --- |
| Java | JDK 17+, Maven | `mvn test` |
| C# | .NET 8 SDK | `dotnet test` |
| Python | Python 3.10+ | `pip install pytest` then `pytest` |
| C++ | CMake 3.16+, a C++17 compiler | `cmake -S . -B build && cmake --build build && ctest --test-dir build` |

All four run automatically on every push via GitHub Actions.

## Start here: the characterisation example

If you only look at one thing, look at [`java/src/main/java/com/revivinglegacycode/characterisation/ShippingCostCalculator.java`](java/src/main/java/com/revivinglegacycode/characterisation/ShippingCostCalculator.java) and its two test classes. It's a small, realistic legacy class with no specification and two behaviours that look like bugs. The tests pin down what it does **today** — bugs included — so it can be refactored safely:

- `ShippingCostCharacterisationTest` documents individual behaviours, flagging the suspicious ones.
- `ShippingCostGoldenMasterTest` compares 120 input combinations against an approved snapshot, so any behavioural change shows up as a diff.

## Found a problem?

Please [open an issue](../../issues) for errors in the code or the book. Corrections are listed in [ERRATA.md](ERRATA.md).

## Licence

Code in this repository is released under the [MIT Licence](LICENSE). The book's text is © Baljeet Dogra and is not covered by this licence.

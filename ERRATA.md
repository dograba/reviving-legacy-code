# Errata — *Reviving Legacy Code*, 1st edition (2023)

Corrections to the first edition (paperback ISBN 9798393846954). Page numbers refer to the paperback. These are fixed in the revised printing and in the 2nd edition.

Found another error? Please [open an issue](../../issues).

## Text that says the opposite of what was meant

| Page | Printed | Should read |
| --- | --- | --- |
| 1 | "…or needs a better design or architecture" | "…or lacks a sound design or architecture" |
| 2 | "may have yet to be developed with the latest best practices" | "was not developed with current best practices" |
| 2 | "The codebase may need more documentation" | "The codebase often lacks documentation" |
| 3 | "more consumer-friendly" | "more user-friendly" |
| 4 | "knowledge … that may need to be fully documented elsewhere" | "…that may not be documented anywhere else" |
| 6 | "need help maintaining code quality standards" | "struggle to maintain code quality standards" |
| 7 | "requires more testing to uncover undiscovered bugs" | "has too little test coverage, so bugs go undetected" |
| 7 | "developers needing access to necessary tools" | "developers lacking the necessary tools" |
| 7 | "when the software system needs more documentation" | "when documentation is missing or out of date" |
| 7 | "when documentation needs to be prioritised over development tasks" | "when documentation is deprioritised in favour of development" |
| 20 | "complex databases that must be fixed to work with" | "complex databases that are hard to work with" |
| 23 | "profile the application to mine performance bottlenecks" | "…to find performance bottlenecks" |
| 24 | "essential management practices" | "key management practices" |
| 41 | "achieve more excellent business value" | "achieve greater business value" |
| 44 | "The company needed help finding developers" | "The company struggled to find developers" |
| 44 | "The legacy language and the necessary features and libraries … must be updated" | "The legacy language was no longer maintained and lacked the libraries modern development needs" |
| 44 | "the application took time to maintain" | "the application was slow and costly to maintain" |
| 46 | "the business needed more customers and revenue" | "the business was losing customers and revenue" |
| 48 | "the team needed help to detect and fix defects quickly" | "the team struggled to detect and fix defects quickly" |
| 48 | "The codebase needed more proper testing coverage" | "The codebase lacked adequate test coverage" |
| 52 | "inefficient, poorly written code accumulating over time, making it easier to maintain" | "…making it harder to maintain" |
| 53 | "code that is not difficult to understand" | "code that is easy to understand" |

## Typos and grammar

| Page | Printed | Should read |
| --- | --- | --- |
| 10 | "a new methods" | "a new method" |
| 11 | "Introduce Parameter Objects, Move Method, and Extract Interface, other techniques that…" | "Introduce Parameter Object, Move Method and Extract Interface are other techniques that…" |
| 36 | "simplify of the codebase" | "simplify the codebase" |
| 53 | "codes quality" | "code quality" |

## Technical corrections

| Page | Issue | Correction |
| --- | --- | --- |
| 14 | "DevMate" is cited as a test-generation tool; we could not verify a tool by this name | Removed. See Chapter 8 of the 2nd edition for verified AI test-generation tools |
| 27–28 | The Java example text refers to "the sound an animal makes" and "new types of animals"; there is no "before" code; the example uses trademarked characters | Replaced with an account-fee example showing the switch before and the polymorphic classes after — see [`java/`](java/) |
| 29 | "the type name keyword" | "the `typename` keyword" |
| 30–31 | The legacy C# example uses `_length` and `_width` without declaring them, so it does not compile | Fields declared — see [`csharp/`](csharp/) |
| 33 | The text says the UI "is now decoupled", but the refactored `AreaCalculator` still writes to `lblResult` | `AreaCalculator` now returns a value; parsing and display stay in the UI — see [`csharp/`](csharp/) |
| 34 | Garbage collection and object caching are described as preventing memory leaks | They don't prevent leaks caused by lingering references; paragraph replaced with profiling advice (`tracemalloc`) |
| 34–35 | The chapter recommends generator expressions but the example doesn't use one | Refactored example uses `sum(... for ...)` — see [`python/`](python/) |
| 37 | Defect density described as defects "per line of code" | Defects per thousand lines of code (KLOC) or per function point |
| 27, 33, 35 | Code names printed with literal backticks | Set in code font |

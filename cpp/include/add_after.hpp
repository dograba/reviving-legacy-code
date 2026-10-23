#pragma once

// AFTER: one function template replaces the overloads (Chapter 7).
// The `typename` keyword declares the type parameter T, which the compiler
// deduces from the arguments at each call site.
namespace after {

template <typename T>
T add(T a, T b) {
    return a + b;
}

}  // namespace after

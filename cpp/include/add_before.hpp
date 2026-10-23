#pragma once

// BEFORE: duplicated overloads (Chapter 7).
// The same logic is written twice and must be maintained twice.
namespace before {

inline int add(int a, int b) {
    return a + b;
}

inline float add(float a, float b) {
    return a + b;
}

}  // namespace before

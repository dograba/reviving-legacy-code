// Proves the template preserves the behaviour of the original overloads.
// Plain asserts keep the sample dependency-free; real projects would use
// GoogleTest or Catch2.

#include <cstdlib>
#include <iostream>

#include "add_after.hpp"
#include "add_before.hpp"

namespace {

int failures = 0;

template <typename T>
void expect_same(T before_result, T after_result, const char* label) {
    if (before_result != after_result) {
        std::cerr << "FAIL: " << label << " before=" << before_result
                  << " after=" << after_result << '\n';
        ++failures;
    }
}

}  // namespace

int main() {
    expect_same(before::add(2, 3), after::add(2, 3), "int 2+3");
    expect_same(before::add(-7, 7), after::add(-7, 7), "int -7+7");
    expect_same(before::add(1.5f, 2.25f), after::add(1.5f, 2.25f), "float 1.5+2.25");
    expect_same(before::add(0.1f, 0.2f), after::add(0.1f, 0.2f), "float 0.1+0.2");

    // The template also works for types the overloads never covered.
    if (after::add(1.5, 2.5) != 4.0) {
        std::cerr << "FAIL: double 1.5+2.5\n";
        ++failures;
    }

    if (failures == 0) {
        std::cout << "All add() equivalence checks passed\n";
        return EXIT_SUCCESS;
    }
    return EXIT_FAILURE;
}

cmake_minimum_required(VERSION 3.16)
project(reviving_legacy_code_cpp LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

enable_testing()

add_executable(test_add tests/test_add.cpp)
target_include_directories(test_add PRIVATE include)
add_test(NAME add_equivalence COMMAND test_add)

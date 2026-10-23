"""Proves the refactoring preserved behaviour: before and after agree on every case."""

import pytest

from total_price import after, before

CASES = [
    [],
    [{"price": 10, "quantity": 1}],
    [{"price": 2.50, "quantity": 4}, {"price": 0.99, "quantity": 3}],
    [{"price": 0, "quantity": 100}],
    [{"price": 19.99, "quantity": 0}],
    [{"price": 1_000_000, "quantity": 7}],
]


@pytest.mark.parametrize("products", CASES)
def test_refactored_total_matches_original(products):
    assert after.calculate_total_price(products) == pytest.approx(
        before.calculate_total_price(products)
    )


def test_empty_basket_totals_zero():
    assert before.calculate_total_price([]) == 0
    assert after.calculate_total_price([]) == 0


def test_missing_key_raises_the_same_error_in_both():
    broken = [{"price": 5}]
    with pytest.raises(KeyError):
        before.calculate_total_price(broken)
    with pytest.raises(KeyError):
        after.calculate_total_price(broken)

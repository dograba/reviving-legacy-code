"""AFTER: Extract Function, plus a generator expression (Chapter 7).

The per-line calculation gets a name, and the loop becomes a sum.
"""


def line_total(product: dict) -> float:
    return product["price"] * product["quantity"]


def calculate_total_price(products: list[dict]) -> float:
    return sum(line_total(p) for p in products)

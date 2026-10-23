"""BEFORE: Extract Function (Chapter 7).

The original version: one function that loops, multiplies and accumulates.
"""


def calculate_total_price(products):
    total_price = 0
    for product in products:
        price = product["price"]
        quantity = product["quantity"]
        subtotal = price * quantity
        total_price += subtotal
    return total_price

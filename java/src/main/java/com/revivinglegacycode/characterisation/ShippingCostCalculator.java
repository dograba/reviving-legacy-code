package com.revivinglegacycode.characterisation;

/**
 * A deliberately "legacy" class for the characterisation-testing example (Chapter 3).
 *
 * Nobody remembers the exact rules, there is no specification, and it has at least
 * two behaviours that look like bugs. Before refactoring it, we pin down what it
 * does TODAY with characterisation tests and a golden master. See the tests in
 * src/test/java/com/revivinglegacycode/characterisation.
 *
 * Do not "fix" this class: the point of the example is that its current behaviour,
 * quirks included, is what the business has been running on.
 */
public class ShippingCostCalculator {

    public double cost(double weightKg, String zone, double orderTotal) {
        if (orderTotal > 50) return 0;          // "free shipping on orders of £50" - but > not >=
        int w = (int) weightKg;                 // truncates: 2.9 kg is charged as 2 kg
        double base;
        if (zone.equals("UK")) base = 3.99;
        else if (zone.equals("EU")) base = 7.50;
        else base = 12.00;
        if (w > 1) base = base + (w - 1) * 1.25;
        if (zone.equals("EU") && w > 10) base = base * 1.1;
        return Math.round(base * 100) / 100.0;
    }
}

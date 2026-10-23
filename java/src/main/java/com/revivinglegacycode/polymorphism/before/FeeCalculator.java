package com.revivinglegacycode.polymorphism.before;

/**
 * BEFORE: Replace Conditional with Polymorphism (Chapter 7).
 * Every new account type means editing this switch.
 */
public class FeeCalculator {

    public double monthlyFee(LegacyAccount a) {
        switch (a.getType()) {
            case "BASIC":    return 0.0;
            case "PREMIUM":  return 12.50;
            case "BUSINESS": return 25.0 + a.getUsers() * 2.0;
            default: throw new IllegalArgumentException(a.getType());
        }
    }
}

package com.revivinglegacycode.polymorphism.after;

/**
 * AFTER: Replace Conditional with Polymorphism (Chapter 7).
 * Each account type owns its own fee rule, so adding a type
 * means adding a class, not editing a switch.
 */
public abstract class Account {
    public abstract double monthlyFee();
}

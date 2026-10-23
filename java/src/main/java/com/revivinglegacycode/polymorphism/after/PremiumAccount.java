package com.revivinglegacycode.polymorphism.after;

public class PremiumAccount extends Account {
    @Override
    public double monthlyFee() {
        return 12.50;
    }
}

package com.revivinglegacycode.polymorphism.after;

public class BusinessAccount extends Account {
    private final int users;

    public BusinessAccount(int users) {
        this.users = users;
    }

    @Override
    public double monthlyFee() {
        return 25.0 + users * 2.0;
    }
}

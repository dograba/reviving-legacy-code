package com.revivinglegacycode.polymorphism.before;

/**
 * Legacy account record: the account type is a string,
 * and every rule about it lives in a switch somewhere else.
 */
public class LegacyAccount {
    private final String type;
    private final int users;

    public LegacyAccount(String type, int users) {
        this.type = type;
        this.users = users;
    }

    public String getType() {
        return type;
    }

    public int getUsers() {
        return users;
    }
}

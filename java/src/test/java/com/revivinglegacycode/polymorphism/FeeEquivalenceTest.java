package com.revivinglegacycode.polymorphism;

import com.revivinglegacycode.polymorphism.after.Account;
import com.revivinglegacycode.polymorphism.after.BasicAccount;
import com.revivinglegacycode.polymorphism.after.BusinessAccount;
import com.revivinglegacycode.polymorphism.after.PremiumAccount;
import com.revivinglegacycode.polymorphism.before.FeeCalculator;
import com.revivinglegacycode.polymorphism.before.LegacyAccount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Proves the refactoring preserved behaviour: for every account type and a range
 * of user counts, the polymorphic version returns exactly what the switch did.
 */
class FeeEquivalenceTest {

    private final FeeCalculator legacy = new FeeCalculator();

    @ParameterizedTest(name = "{0} with {1} users")
    @CsvSource({
            "BASIC, 0", "BASIC, 5",
            "PREMIUM, 0", "PREMIUM, 5",
            "BUSINESS, 0", "BUSINESS, 1", "BUSINESS, 10", "BUSINESS, 250"
    })
    void refactoredFeeMatchesLegacyFee(String type, int users) {
        double before = legacy.monthlyFee(new LegacyAccount(type, users));
        double after = toRefactored(type, users).monthlyFee();
        assertEquals(before, after);
    }

    @Test
    void legacyRejectsUnknownTypes() {
        assertThrows(IllegalArgumentException.class,
                () -> legacy.monthlyFee(new LegacyAccount("GOLD", 1)));
    }

    private static Account toRefactored(String type, int users) {
        switch (type) {
            case "BASIC":    return new BasicAccount();
            case "PREMIUM":  return new PremiumAccount();
            case "BUSINESS": return new BusinessAccount(users);
            default: throw new IllegalArgumentException(type);
        }
    }
}

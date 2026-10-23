package com.revivinglegacycode.characterisation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Characterisation tests: they describe what ShippingCostCalculator does TODAY,
 * not what it should do. Each expected value was obtained by running the
 * existing code, not by reading a specification.
 *
 * When a test documents behaviour that looks wrong, it still asserts the current
 * behaviour and says so. Fixing a bug is a separate, deliberate change - made only
 * after the business confirms the intended rule.
 */
class ShippingCostCharacterisationTest {

    private final ShippingCostCalculator calculator = new ShippingCostCalculator();

    @Test
    void ukParcelUnderOneKgPaysTheBaseRate() {
        assertEquals(3.99, calculator.cost(0.5, "UK", 20.00));
    }

    @Test
    void eachWholeKgAboveTheFirstAddsOnePoundTwentyFive() {
        assertEquals(3.99 + 4 * 1.25, calculator.cost(5.0, "UK", 20.00), 0.001);
    }

    @Test
    void unknownZonesAreChargedTheRestOfWorldRate() {
        assertEquals(12.00, calculator.cost(1.0, "XX", 20.00));
    }

    @Test
    void heavyEuParcelsCarryATenPercentSurcharge() {
        // 11 kg to the EU: (7.50 + 10 * 1.25) * 1.1 = 22.00
        assertEquals(22.00, calculator.cost(11.0, "EU", 20.00));
    }

    @Test
    void currentBehaviour_weightIsTruncatedNotRoundedUp() {
        // LOOKS LIKE A BUG: 2.9 kg is charged as 2 kg. Confirm the intended rule
        // with the business before changing it.
        assertEquals(calculator.cost(2.0, "UK", 20.00), calculator.cost(2.9, "UK", 20.00));
    }

    @Test
    void currentBehaviour_orderOfExactlyFiftyPoundsStillPaysShipping() {
        // LOOKS LIKE A BUG: the website promises free shipping "on orders of £50",
        // but the code uses > rather than >=.
        assertEquals(3.99, calculator.cost(0.5, "UK", 50.00));
        assertEquals(0.0, calculator.cost(0.5, "UK", 50.01));
    }
}

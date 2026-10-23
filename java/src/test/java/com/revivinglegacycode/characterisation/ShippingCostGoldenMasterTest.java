package com.revivinglegacycode.characterisation;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Golden master (approval) test, Chapter 3.
 *
 * Runs the calculator over a grid of inputs and compares the full output with an
 * approved snapshot captured from the unmodified legacy code. Any behavioural
 * change - intended or not - shows up as a diff against
 * src/test/resources/shipping-golden-master.txt.
 *
 * If you change behaviour deliberately, regenerate the snapshot with
 * {@link #render()} and review the diff line by line before committing it.
 */
class ShippingCostGoldenMasterTest {

    static final String[] ZONES = {"UK", "EU", "ROW"};
    static final double[] WEIGHTS = {0, 0.5, 1, 1.9, 2, 5.5, 10, 10.5, 11, 25};
    static final double[] TOTALS = {0, 49.99, 50, 50.01};

    static String render() {
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        StringBuilder out = new StringBuilder();
        for (String zone : ZONES) {
            for (double weight : WEIGHTS) {
                for (double total : TOTALS) {
                    out.append(String.format(Locale.ROOT, "%s weight=%.1f total=%.2f -> %.2f%n",
                            zone, weight, total, calculator.cost(weight, zone, total)));
                }
            }
        }
        return out.toString();
    }

    @Test
    void outputMatchesTheApprovedSnapshot() throws IOException {
        String approved;
        try (InputStream in = getClass().getResourceAsStream("/shipping-golden-master.txt")) {
            assertNotNull(in, "Approved snapshot is missing");
            approved = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        assertEquals(normalise(approved), normalise(render()));
    }

    private static String normalise(String s) {
        return s.replace("\r\n", "\n").strip();
    }

    /** Prints the current output, for regenerating the snapshot after a reviewed change. */
    public static void main(String[] args) {
        System.out.print(render());
    }
}

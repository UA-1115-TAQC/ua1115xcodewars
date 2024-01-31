package org.academy.kata.provider;
import org.academy.kata.Five;
import org.academy.kata.Six;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class SixTest {
    @Test(dataProvider = "floatingPoint_validInputs", dataProviderClass = SixDataProvider.class)
    public void floatingPointTest(Six impl, double x, double expected) {
        assertFuzzyEquals(impl.f(x), expected,  8.470329472543003390683225e-22);
    }

    public static void assertFuzzyEquals(double expected, double actual, double tolerance) {
        if (Math.abs(expected - actual) >= tolerance) {
            throw new AssertionError("Values are not equal. Expected: " + expected + ", Actual: " + actual + ", Tolerance: " + tolerance);
        }
    }
}

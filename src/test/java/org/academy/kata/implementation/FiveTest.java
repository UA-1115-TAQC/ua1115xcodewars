package org.academy.kata.implementation;

import org.academy.kata.Five;
import org.academy.kata.provider.FiveDataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FiveTest {

    @Test(dataProvider = "gap", dataProviderClass = FiveDataProvider.class)
    public void gapTest(Five impl, int input1, long input2, long input3, long[] expected) {
        assertEquals(Arrays.toString(impl.gap(input1, input2, input3)), Arrays.toString(expected));
    }

    @Test(dataProvider = "test_data_zeros", dataProviderClass = FiveDataProvider.class)
    public void test_zeros(Five impl, int n, int expected) {
        assertEquals(impl.zeros(n), expected);
    }

    @Test(dataProvider = "which_x_for_that_sum", dataProviderClass = FiveDataProvider.class)
    public void whichXForThatSum_validData_ok(Five five, double input, double expected) {
        double merr = 1e-12;
        double actual = five.solve(input);
        boolean inRange = Math.abs(actual - expected) <= merr;
        assertTrue(inRange);
    }
    @Test(dataProvider = "Find the smallest value", dataProviderClass = FiveDataProvider.class)
    public void returnTheSmallestNumber(Five five, long givenNumber, long[] expectedNumber){
        assertEquals(expectedNumber, five.smallest(givenNumber));
    }
    @Test(dataProvider = "perimeterData", dataProviderClass = FiveDataProvider.class)
    public void perimeterTest(Five five, BigInteger number, BigInteger expected){
        assertEquals(five.perimeter(number), expected);
    }
}

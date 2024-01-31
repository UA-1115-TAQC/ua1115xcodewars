package org.academy.kata.implementation;

import org.academy.kata.Five;
import org.academy.kata.provider.FiveDataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class FiveTest {

    @Test(dataProvider = "gap", dataProviderClass = FiveDataProvider.class)
    public void gapTest(Five impl, int input1, long input2, long input3, long[] expected) {
        assertEquals(Arrays.toString(impl.gap(input1, input2, input3)), Arrays.toString(expected));
    }

    @Test(dataProvider = "test_data_zeros", dataProviderClass = FiveDataProvider.class)
    public void test_zeros(Five impl, int n, int expected) {
        assertEquals(impl.zeros(n), expected);
    }
}

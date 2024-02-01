package org.academy.kata.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiveDataProvider extends AbstractDataProvider {


    @DataProvider(name = "gap")
    public static Iterator<Object[]> gapData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{10, 300, 400, new long[]{337, 347}});
        inputs.add(new Object[]{2, 100, 110, new long[]{101, 103}});
        inputs.add(new Object[]{4, 100, 110, new long[]{103, 107}});
        inputs.add(new Object[]{6, 100, 110, null});
        return combineData(inputs, FIVES);
    }

    @DataProvider(name = "test_data_zeros")
    private Iterator<Object[]> test_data_zeros() {
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[]{0, 0});
        testData.add(new Object[]{6, 1});
        testData.add(new Object[]{14, 2});
        testData.add(new Object[]{20, 4});
        testData.add(new Object[]{100, 24});
        return combineData(testData, FIVES);
    }

    @DataProvider(name = "which_x_for_that_sum")
    private Iterator<Object[]> whichXForThatSumData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2.00, 5.000000000000e-01});
        inputs.add(new Object[]{4.00, 6.096117967978e-01});
        inputs.add(new Object[]{5.00, 6.417424305044e-01});
        return combineData(inputs, FIVES);
    }

    @DataProvider(name = "Find the smallest value")
    private Iterator<Object[]> findTheSmallestValue() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{261235, new long[]{126235, 2, 0}});
        inputs.add(new Object[]{209917, new long[]{29917, 0, 1}});
        inputs.add(new Object[]{285365, new long[]{238565, 3, 1}});
        inputs.add(new Object[]{269045, new long[]{26945, 3, 0}});
        inputs.add(new Object[]{296837, new long[]{239687, 4, 1}});
        return combineData(inputs, FIVES);
    }
}

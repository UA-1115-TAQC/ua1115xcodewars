package org.academy.kata.provider;


import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SevenDataProvider extends AbstractDataProvider {

    @DataProvider(name = "newAvgSuccess")
    private Iterator<Object[]> newAvg() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new double[]{14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0}, 90, 628});
        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645});
        return combineData(inputs, SEVEN);
    }

    @DataProvider(name = "newAvgException")
    private Iterator<Object[]> IllegalArgumentException() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new double[]{14, 30, 5, 7, 9, 11, 15}, 2});
        return combineData(inputs, SEVEN);
    }
    @DataProvider(name = "seriesSum")
    private Iterator<Object[]> seriesSum() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1, "1.00"});
        inputs.add(new Object[]{2, "1.25"});
        inputs.add(new Object[]{3, "1.39"});
        inputs.add(new Object[]{5, "1.57"});
        inputs.add(new Object[]{9, "1.77"});
        inputs.add(new Object[]{15, "1.94"});
        inputs.add(new Object[]{0, "0.00"});

        return combineData(inputs, SEVEN);
    };
}

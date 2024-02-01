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
}

package org.academy.kata.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EightDataProvider extends AbstractDataProvider {

    @DataProvider(name = "stringToNumber")
    public static Iterator<Object[]> stringToNumberData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{"90", 90});
        inputs.add(new Object[]{"645", 645}); // input, result
        inputs.add(new Object[]{"-7", -7}); // input1, input2, result

        return combineData(inputs, FIVES);
    }
    @DataProvider(name = "test_data_wilson")
    private Iterator<Object[]> test_data_wilson(){
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[] {5, true});
        testData.add(new Object[] {11, false});
        testData.add(new Object[] {13, true});
        testData.add(new Object[] {88, false});
        testData.add(new Object[] {563, true});
        return combineData(testData, EIGHTS);
    }
}


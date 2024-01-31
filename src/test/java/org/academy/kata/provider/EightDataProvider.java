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
        inputs.add(new Object[]{"645", 645});
        inputs.add(new Object[]{"-7", -7});

        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "test_data_wilson")
    private Iterator<Object[]> test_data_wilson() {
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[]{5, true});
        testData.add(new Object[]{11, false});
        testData.add(new Object[]{13, true});
        testData.add(new Object[]{88, false});
        testData.add(new Object[]{563, true});
        return combineData(testData, EIGHTS);
    }


    @DataProvider(name = "VolumeOfCuboid_validInputs")
    public static Iterator<Object[]> VolumeOfCuboid_validInputs() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1, 2, 2, 4});
        inputs.add(new Object[]{10.5, 2, 5, 105});
        inputs.add(new Object[]{5.5, 1.2, 3.7, 24.42});
        inputs.add(new Object[]{1, 1, 1, 1});
        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "VolumeOfCuboid_invalidInputs")
    public Iterator<Object[]> VolumeOfCuboid_invalidInputs() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{-1, 2, 3});
        inputs.add(new Object[]{0, 5.0, 6.0});
        inputs.add(new Object[]{2.5, -3.0, 4.0});
        inputs.add(new Object[]{-2.0, -3.0, 4.0});
        inputs.add(new Object[]{-1, -2, -2});
        return combineData(inputs, EIGHTS);
    }

}


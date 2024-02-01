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


    @DataProvider(name = "VolumeOfCuboid_validInputs")
    public static Iterator<Object[]>VolumeOfCuboid_validInputs() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1,2,2, 4});
        inputs.add(new Object[]{10.5, 2,5,105});
        inputs.add(new Object[]{5.5, 1.2, 3.7, 24.42});
        inputs.add(new Object[]{1,1,1,1});
        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "liters_test")
    public static Iterator<Object[]>liters_test_data() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2.0,1});
        inputs.add(new Object[]{0.97,0});
        inputs.add(new Object[]{14.64,7});
        inputs.add(new Object[]{1600.20,800});
        inputs.add(new Object[]{80,40});
        return combineData(inputs, EIGHTS);
    }

}


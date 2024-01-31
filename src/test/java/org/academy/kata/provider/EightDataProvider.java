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

    @DataProvider(name = "divisibleByData")
    public Iterator<Object[]> divisibleByData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[] {1,2,3,4,5,6}, 2, new int[] {2,4,6}});
        inputs.add(new Object[]{new int[] {1,2,3,4,5,6}, 3, new int[] {3,6}});
        inputs.add(new Object[]{new int[] {0,1,2,3,4,5,6}, 4, new int[] {0,4}});
        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "mpgToKpmValid")
    public Iterator<Object[]> mpgToKpmValid() {
        List<Object[]> testData = List.of(
                new Object[] {10, 3.54f},
                new Object[] {20, 7.08f},
                new Object[] {30, 10.62f},
                new Object[] {10.05f, 3.56f},
                new Object[] {0, 0}
        );
        return combineData(testData, EIGHTS);
    }
}


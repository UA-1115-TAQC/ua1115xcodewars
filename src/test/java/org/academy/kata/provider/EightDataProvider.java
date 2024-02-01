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
        inputs.add(new Object[]{new int[]{1, 2, 3, 4, 5, 6}, 2, new int[]{2, 4, 6}});
        inputs.add(new Object[]{new int[]{1, 2, 3, 4, 5, 6}, 3, new int[]{3, 6}});
        inputs.add(new Object[]{new int[]{0, 1, 2, 3, 4, 5, 6}, 4, new int[]{0, 4}});
        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "squareOrSquareRoot")
    public static Iterator<Object[]> test_squareOrSquareRoot() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[]{4, 3, 9, 7, 2, 1}, new int[]{2, 9, 3, 49, 4, 1}});
        inputs.add(new Object[]{new int[]{100, 101, 5, 5, 1, 1}, new int[]{10, 10201, 25, 25, 1, 1}});
        inputs.add(new Object[]{new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 4, 9, 2, 25, 36}});
        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "liters_test")
    public static Iterator<Object[]> liters_test_data() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2.0,1});
        inputs.add(new Object[]{0.97,0});
        inputs.add(new Object[]{14.64,7});
        inputs.add(new Object[]{1600.20,800});
        inputs.add(new Object[]{80,40});

        return combineData(inputs, EIGHTS);
    }

    @DataProvider(name = "countPositivesSumNegatives")
    public Iterator<Object[]> countPositivesSumNegatives() {
        List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{null, new int[]{}});
        inputs.add(new Object[]{new int[]{}, new int[]{}});

        inputs.add(new Object[]{new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}, new int[]{10, -65}});
        inputs.add(new Object[]{new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}, new int[]{8, -50}});

        inputs.add(new Object[]{new int[]{1, 2, 3, 4, 5, 6, 0}, new int[]{6, 0}});
        inputs.add(new Object[]{new int[]{-1, -2, -3, -4, 0}, new int[]{0, -10}});
        inputs.add(new Object[]{new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0}});
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


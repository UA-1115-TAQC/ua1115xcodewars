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
}


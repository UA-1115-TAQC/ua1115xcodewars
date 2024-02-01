package org.academy.kata.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiveDataProvider extends AbstractDataProvider {


    @DataProvider(name = "gap")
    public static Iterator<Object[]> gapData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{10, 300, 400, new long[]{337, 347}}); // input1, input2, input3, result
        inputs.add(new Object[]{2, 100, 110, new long[]{101, 103}});  // input1, input2, input3, result
        inputs.add(new Object[]{4, 100, 110, new long[]{103, 107}});  // input1, input2, input3, result
        inputs.add(new Object[]{6, 100, 110, null});                  // input1, input2, input3, result

        return combineData(inputs, FIVES);
    }

    @DataProvider(name = "test_data_zeros")
    private Iterator<Object[]> test_data_zeros(){
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[] {0, 0});
        testData.add(new Object[] {6, 1});
        testData.add(new Object[] {14, 2});
        testData.add(new Object[] {20, 4});
        testData.add(new Object[] {100, 24});
        return combineData(testData, FIVES);
    }
}

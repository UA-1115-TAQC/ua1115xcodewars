package org.academy.kata.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class EightDataProvider extends AbstractDataProvider {

    @DataProvider(name = "stringToNumber")
    public static Object[][] stringToNumberData() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{"90", 90});
        inputs.add(new Object[]{"645", 645}); // input, result
        inputs.add(new Object[]{"-7", -7}); // input1, input2, result

        return getDataOneParam(inputs, FIVES);
    }
}


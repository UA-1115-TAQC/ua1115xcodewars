package org.academy.kata.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SixDataProvider extends AbstractDataProvider{

    @DataProvider(name = "floatingPoint_validInputs")
    private Iterator<Object[]> floatingPoint_validInputs(){
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[] {2.6e-08, 1.29999999155e-08});
        testData.add(new Object[] {5.0e-06, 2.499996875007812e-06});
        testData.add(new Object[] {1.4e-09,6.999999997549999e-10});
        testData.add(new Object[] {2.4e-07, 1.1999999280000085e-07});
        return combineData(testData, SIXES);
    }
}

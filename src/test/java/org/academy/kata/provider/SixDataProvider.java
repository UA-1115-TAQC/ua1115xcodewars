package org.academy.kata.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SixDataProvider extends AbstractDataProvider{

    @DataProvider(name = "floatingPoint")
    private Iterator<Object[]> floatingPoint(){
        List<Object[]> testData = new ArrayList<>();
        testData.add(new Object[] {2.6e-08, 1.29999999155e-08});
        testData.add(new Object[] {0,0});
        testData.add(new Object[] {-1,-1});
        testData.add(new Object[] {-1.4e-09,-(2.499996875007812e-06)});
        testData.add(new Object[] {5.0e-06, 2.499996875007812e-06});
        testData.add(new Object[] {1.4e-09,6.999999997549999e-10});
        testData.add(new Object[] {2.4e-07, 1.1999999280000085e-07});
        return combineData(testData, SIXES);
    }

    @DataProvider(name = "helpBookseller")
    public Iterator<Object[]> helpBookseller(){
        List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                new String[] {"A", "B"},
                "(A : 200) - (B : 1140)"});
        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"},
                new String[] {"A", "B", "W"},
                "(A : 200) - (B : 1140) - (W : 0)"});

        inputs.add(new Object[]{null, new String[] {"A", "B"}, ""});
        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500"}, null, ""});

        inputs.add(new Object[]{new String[]{}, new String[] {"A", "B"}, ""});
        inputs.add(new Object[]{new String[]{"ABAR 200", "CDXE 500"}, new String[]{}, ""});

        return combineData(inputs, SIXES);
    }
}
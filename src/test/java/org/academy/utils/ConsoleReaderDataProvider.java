package org.academy.utils;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;

public class ConsoleReaderDataProvider {
    @DataProvider(name = "validDataForIntArr")
    private Object[][] validDataForIntArr(){
        return new Object[][]{
                {"0", new int[]{0}},
                {"2 4 6 8", new int[]{2, 4, 6, 8}},
                {"11 24 -3", new int[]{11, 24, -3}},
                {"-5  -10  -15", new int[]{-5, -10, -15}},
                {"100 200 300", new int[]{100, 200, 300}},
                {"-1 0 1", new int[]{-1, 0, 1}},
                {"999 -999", new int[]{999, -999}},
        };
    }

    @DataProvider(name = "validDataForBigInt")
    private Object[][] validDataForBigInt(){
        return new Object[][]{
                {"43653664", new BigInteger("43653664")},
                {"67648656565474858", new BigInteger("67648656565474858")},
                {"9597957656756756788655685656", new BigInteger("9597957656756756788655685656")},
        };
    }

    @DataProvider(name = "validDataForDoubleArr")
    private Object[][] validDataForDoubleArr(){
        return new Object[][]{
                {"1 2 3", new double[]{1.0, 2.0, 3.0}},
                {"10.5 4.2 -2.1", new double[]{10.5, 4.2, -2.1}},
                {"  5    6.7   ", new double[]{5.0, 6.7}},
                {"0", new double[]{0.0}},
        };
    }

    @DataProvider(name = "invalidDataForDoubleArr")
    private Object[][] invalidDataForDoubleArr(){
        return new Object[][]{
                {"a b c"},
                {"1.2.3"},
                {"5  hello"},
                {" "},
                {"10,5 4,2 -2,1"}
        };
    }

    @DataProvider(name = "readFloatPositiveTest")
    public Object[][] readFloatPos(){
        Object[][] result = new Object[][]{
                new Object[]{"1.11", 1.11F},
                new Object[]{"1.11f", 1.11F},
                new Object[]{"1.11F", 1.11F},
        };
        return result;
    }
}
package org.academy.utils;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;
import java.util.Arrays;

public class ConsoleReaderDataProvider {
    @DataProvider(name = "validDataForIntArr")
    private Object[][] validDataForIntArr() {
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
    private Object[][] validDataForBigInt() {
        return new Object[][]{
                {"0", new BigInteger("0")},
                {"-255", new BigInteger("-255")},
                {"9597957656756756788655685656", new BigInteger("9597957656756756788655685656")},
        };
    }

    @DataProvider(name = "invalidDataForBigInt")
    private Object[][] invalidDataForBigInt() {
        return new Object[][]{
                {"", "Input should be a big integer." + System.lineSeparator()},
                {"asdfghjk", "Input should be a big integer." + System.lineSeparator()},
        };
    }

    @DataProvider(name = "validDataForDoubleArr")
    private Object[][] validDataForDoubleArr() {
        return new Object[][]{
                {"1 2 3", new double[]{1.0, 2.0, 3.0}},
                {"10.5 4.2 -2.1", new double[]{10.5, 4.2, -2.1}},
                {"  5    6.7   ", new double[]{5.0, 6.7}},
                {"0", new double[]{0.0}},
        };
    }

    @DataProvider(name = "invalidDataForDoubleArr")
    private Object[][] invalidDataForDoubleArr() {
        return new Object[][]{
                {"a b c\n a b c \n1", "Input should be a double array."+ System.lineSeparator()+"Input should be a double array.", new double[]{1}},
                {"1.2.3 \n1", "Input should be a double array.", new double[]{1}},
                {"5  hello\n1", "Input should be a double array.", new double[]{1}},
                {" \n1", "Input should be a double array.", new double[]{1}},
                {"10,5 4,2 -2,1\n1", "Input should be a double array.", new double[]{1}}
        };
    }

    @DataProvider(name = "readFloatPositiveTest")
    public Object[][] readFloatPositive() {
        Object[][] result = new Object[][]{
                new Object[]{"1.11f", 1.11f},
                new Object[]{"1.11F", 1.11f},

                new Object[]{"1", 1.0f},
                new Object[]{"1.11", 1.11f},
                new Object[]{"1.247e2", 1.247e2f},
                new Object[]{"-1.247e2", -1.247e2f},

                new Object[]{"340282356779733661637539395458142568447", Float.MAX_VALUE},
                new Object[]{"340282356779733661637539395458142568448", Float.POSITIVE_INFINITY},
                new Object[]{"-340282356779733661637539395458142568448", Float.NEGATIVE_INFINITY},
        };
        return result;
    }

    @DataProvider(name = "readFloatNegativeTest")
    public Object[][] readFloatNegative() {
        Object[][] result = new Object[][]{
                new Object[]{"" + System.lineSeparator() + "1.0",
                        "Input should be a float."},
                new Object[]{" " + System.lineSeparator() + "1.0",
                        "Input should be a float."},
                new Object[]{"1.247c2" + System.lineSeparator() + "1.0",
                        "Input should be a float."},
                new Object[]{"1.247c2" + System.lineSeparator() + "1.247c2" + System.lineSeparator() + "1.0",
                        "Input should be a float." + System.lineSeparator() + "Input should be a float."}
        };

        return result;
    }

    @DataProvider(name = "readStringArr")
    private Object[][] readStringArr() {
        return new Object[][]{
                {"Rachel, Chandler, Joey", new String[]{"Rachel", "Chandler", "Joey"}},
                {"one, two, three", new String[]{"one", "two", "three"}},
                {"alevtyna30, 43, Natalia62, !", new String[]{"alevtyna30", "43", "Natalia62", "!"}},
        };
    }

    @DataProvider(name = "readLong")
    private Object[][] readLongData() {
        return new Object[][]{
                {"688768", 688768},
                {"10", 10},
                {"1", 1},
        };
    }

    @DataProvider(name = "string_data")
    private Object[][] readStringValid() {
        return new Object[][] {
                {"abc", "abc"},
                {"1", "1"},
                {" ", ""},
                {"this is string..", "this is string.."},
                {"some string\nsome", "some string"},
                {System.lineSeparator(), ""}
        };
    }
    @DataProvider(name = "validDataForInt")
    public Object[][] readIntValidInput() {
        return new Object[][]{
                {"123\n", 123},
                {"0\n", 0},
                {"-42\n", -42},
        };
    }
    @DataProvider(name = "invalidDataForInt")
    public Object[][] readIntInvalidInput() {
        return new Object[][]{
                {"a b c\n a b c \n1", "Input should be an integer." + System.lineSeparator() + "Input should be an integer.", 1},
                {"14.39 \n1", "Input should be an integer.", 1},
                {"12,8 \n1", "Input should be an integer.", 1},
                {" \n1", "Input should be an integer.", 1},
        };
    }
}

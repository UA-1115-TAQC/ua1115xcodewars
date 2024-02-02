package org.academy.kata;

import org.academy.kata.provider.SixDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SixTest extends BaseTestRunner {
    @Test(dataProvider = "floatingPoint", dataProviderClass = SixDataProvider.class)
    public void floatingPointTest(Six impl, double x, double expected) {
        double aberr = 1e-12;
        double actual= impl.f(x);
        boolean inrange = (expected == 0.0) ?
                (Math.abs(actual) <= aberr) :
                ((Math.abs(actual - expected) / expected)<= aberr);
        if (!inrange) {
            System.out.println("Expected result must be near " + expected +", but got " + actual);
      }
      assertEquals(true, inrange);
    }

    @Test(dataProvider = "helpBookseller", dataProviderClass = SixDataProvider.class)
    public void helpBooksellerTest(Six six, String[] inputBooks, String[] inputLetters, String expected) {
        assertEquals(expected, six.stockSummary(inputBooks, inputLetters));
    }

    @Test(dataProvider = "nbaCup", dataProviderClass = SixDataProvider.class)
    public void nbaCup(Six impl, String resultSheet, String toFind, String expected) {
        assertEquals(impl.nbaCup(resultSheet, toFind), expected);
    }

    @Test(dataProvider = "balance_test", dataProviderClass = SixDataProvider.class)
    public void balance_test(Six impl, String input1, String expected) {
        String result = impl.balance(input1);
        result = result.replaceAll("[\\r\\n\\s]+", " ");
        result = result.replaceAll(",",".");
        result = result.replaceAll("\\\\r", "");
        result = result.replaceAll("\\\\n", "\n");
        result = result.replaceAll("\n", " ");

        expected = expected.replaceAll("[\\r\\n\\s]+", " ");
        expected = expected.replaceAll("\\\\r", "");
        expected = expected.replaceAll("\\\\n", "\n");
        expected = expected.replaceAll("\n", " ");

        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "rainfall_mean_valid", dataProviderClass = SixDataProvider.class)
    public void mean_TestValidData_Ok(Six six, String town, String data, double expected) {
        double actual = six.mean(town, data);
        assertEquals("abs(actual - expected) must be <= 1e-2. Expected was " + expected +", but got " + actual,
                expected, actual, 1e-2);
    }

    @Test(dataProvider = "rainfall_variance_valid", dataProviderClass = SixDataProvider.class)
    public void variance_TestValidData_Ok(Six six, String town, String data, double expected) {
        double actual = six.variance(town, data);
        assertEquals("abs(actual - expected) must be <= 1e-2. Expected was " + expected +", but got " + actual,
                expected, actual, 1e-2);
    }
}

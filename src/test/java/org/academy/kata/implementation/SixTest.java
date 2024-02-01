package org.academy.kata.implementation;

import org.academy.kata.Six;
import org.academy.kata.provider.SixDataProvider;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

import static org.testng.AssertJUnit.assertEquals;


public class SixTest {
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
    public void nbaCup(Six impl, String resultSheet1, String resultSheet2, String toFind, String expected) {
        String resultSheet = resultSheet1 + resultSheet2;
        assertEquals(impl.nbaCup(resultSheet, toFind), expected);
    }
}
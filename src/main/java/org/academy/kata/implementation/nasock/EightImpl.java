package org.academy.kata.implementation.nasock;

import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EightImpl implements Eight {
    private static float GALON_TO_LITERS = 4.54609188F;
    private static float MILE_TO_KM = 1.609344F;

    public int liters(double time) {
        return 0;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    public float mpgToKPM(float mpg) {
        if (mpg < 0) {
            throw new IllegalArgumentException();
        }

        float kpl  = mpg * MILE_TO_KM / GALON_TO_LITERS;
        BigDecimal bd = BigDecimal.valueOf(kpl);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }

    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
    }

    public int stringToNumber(String str) {
        return 0;
    }

    public double TwoDecimalPlaces(double number) {
        return 0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }

    public boolean am_i_wilson(double n) {
        return false;
    }

}

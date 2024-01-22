package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Eight;

public class EightImpl implements Eight {
    public static final float ONE_IMPERIAL_GALLON = 4.54609188f;
    public static final float ONE_KM = 1.609344f;

    public int liters(double time) {
        return 0;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    public float mpgToKPM(float mpg) {
        return (float) Math.round(mpg * ONE_IMPERIAL_GALLON / ONE_KM * 100) / 100;
    }

    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
    }

    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }

    public boolean am_i_wilson(double n) {
        return false;
    }
}

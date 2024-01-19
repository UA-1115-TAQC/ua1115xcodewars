package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Eight;

public class EightImpl implements Eight {
    public int liters(double time) {
        return 0;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    public float mpgToKPM(float mpg) {
        final double IMPERIAL_GALLON = 4.54609188;
        final double MILE = 1.609344;
        if (mpg > 0 ) {
            return  Math.round(mpg * MILE * 100 / IMPERIAL_GALLON) /100.0f;
        }
        throw new IllegalArgumentException("The value must be positive");
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

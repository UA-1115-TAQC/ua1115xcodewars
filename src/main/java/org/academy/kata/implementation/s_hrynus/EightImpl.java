package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Eight;

import java.util.stream.IntStream;

public class EightImpl implements Eight {
    public static final float ONE_IMPERIAL_GALLON = 4.54609188f;
    public static final float ONE_KM = 1.609344f;

    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        return (float) Math.round(mpg * ONE_IMPERIAL_GALLON / ONE_KM * 100) / 100;
    }

    public int[] squareOrSquareRoot(int[] array) {
        return IntStream.of(array)
                .map(x -> (int) (Math.sqrt(x) == (int) Math.sqrt(x)
                        ? Math.sqrt(x) : Math.pow(x, 2)))
                .toArray();
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

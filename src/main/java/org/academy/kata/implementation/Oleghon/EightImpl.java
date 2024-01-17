package org.academy.kata.implementation.Oleghon;

import org.academy.kata.Eight;

public class EightImpl implements Eight {
    public int liters(double time) {
        return 0;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    public float mpgToKPM(float mpg) {
        return 0;
    }

    public int[] squareOrSquareRoot(int[] array) {
        final var resultArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArr[i] = (int) (Math.sqrt(array[i]) % 1 == 0 ? Math.sqrt(array[i]) : Math.pow(array[i], 2));
        }
        return resultArr;
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

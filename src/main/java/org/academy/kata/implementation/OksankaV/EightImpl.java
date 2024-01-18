package org.academy.kata.implementation.OksankaV;

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
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if (input != null && input.length != 0) {
            int countPositive = 0;
            int sumNegative = 0;
            for (int value : input) {
                if (value > 0) countPositive++;
                else if (value < 0) sumNegative += value;
            }
            int[] arr = {countPositive,sumNegative};
            return arr;
        } else
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

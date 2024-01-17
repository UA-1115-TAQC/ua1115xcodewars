package org.academy.kata.implementation.hohashvili;

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
        int countPositives = 0;
        int sumNegatives = 0;
        int[] result = new int[]{};
        if (input == null || input.length == 0) {
            return result;
        }
        for (int value: input) {
            if (value >= 0) {
                countPositives += 1;
            } else {
                sumNegatives += value;
            }
        }
        result = new int[]{countPositives, sumNegatives};
        return result;
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

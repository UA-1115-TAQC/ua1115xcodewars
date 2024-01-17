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

    static double factorial(double n)
    {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }
    public boolean am_i_wilson(double n) {
        double result = (factorial(n-1) + 1) / (n*n);
        return Math.ceil(result) == result;
    }
}

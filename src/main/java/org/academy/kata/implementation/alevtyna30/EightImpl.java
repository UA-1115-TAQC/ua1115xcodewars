package org.academy.kata.implementation.alevtyna30;

import org.academy.kata.Eight;
import java.util.Arrays;

import java.util.Arrays;

public class EightImpl implements Eight {
    private static final double WATER_PER_HOUR = 0.5;
    public int liters(double time) {

        return (int) (time * WATER_PER_HOUR);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length*width*height;
    }

    public float mpgToKPM(float mpg) {
        return 0;
    }

    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        int countPositives = (int) Arrays.stream(input).filter(num -> num > 0).count();
        int sumNegatives = Arrays.stream(input).filter(num -> num < 0).sum();

        return new int[]{countPositives, sumNegatives};
    }

    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {

        return Math.round(number*100.0)/100.0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers)
                .filter(num -> num % divider == 0)
                .toArray();
    }

    public boolean am_i_wilson(double n) {
        if (n <= 1) {
            return false;
        }
        double factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial = (factorial * i) % n;
        }
        return (factorial + 1) % n == 0;

    }
}

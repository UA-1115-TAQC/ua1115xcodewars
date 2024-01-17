package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Eight;

import java.util.stream.IntStream;

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
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        int negativeSum = IntStream.of(input).filter(x -> x < 0).sum();
        int quantityOfPositiveNumbers = (int) IntStream.of(input).filter(x -> x > 0).count();
        return new int[]{quantityOfPositiveNumbers, negativeSum};
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

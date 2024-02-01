package org.academy.kata.implementation.alevtyna30;

import org.academy.kata.Eight;

import java.math.BigInteger;
import java.util.Arrays;


public class EightImpl implements Eight {
    private static final double MILES_TO_KM = 1.609344;
    private static final double GALLONS_TO_LITERS = 4.54609188;
    private static final double WATER_PER_HOUR = 0.5;

    public int liters(double time) {

        return (int) (time * WATER_PER_HOUR);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        return (float) Math.round (100 * (mpg * MILES_TO_KM / GALLONS_TO_LITERS)) / 100;
    }

    public int[] squareOrSquareRoot(int[] array) {
        return Arrays.stream(array)
                .map(number -> {
                    int squareRoot = (int) Math.sqrt(number);
                    return squareRoot * squareRoot == number ? squareRoot : number * number;
                })
                .toArray();
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

        return Math.round(number * 100.0) / 100.0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers)
                .filter(num -> num % divider == 0)
                .toArray();
    }

    public boolean am_i_wilson(double n) {
        if (n <= 1) return false;
        BigInteger number = new BigInteger(String.valueOf((int) n));
        return (factorial(n - 1).add(BigInteger.valueOf(1))).remainder(number.pow(2)).equals(BigInteger.ZERO);
    }

    public BigInteger factorial(double a) {
        BigInteger number = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= a; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        return number;
    }
}

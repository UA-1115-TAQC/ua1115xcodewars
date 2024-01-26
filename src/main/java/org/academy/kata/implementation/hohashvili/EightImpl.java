package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Eight;

import java.util.Arrays;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) Math.floor(time/2);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        float imperialGallonToLiter = 4.54609188F;
        float mileToKm = 1.609344F;
        return mpg*mileToKm/imperialGallonToLiter;
    }

    public int[] squareOrSquareRoot(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            double squareRoot = Math.sqrt(array[i]);
            if (squareRoot == Math.ceil(squareRoot)) {
                newArray[i] = (int) squareRoot;
            } else {
                newArray[i] = (int) Math.pow(array[i], 2);
            }
        }
        return newArray;
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
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        return (double) Math.round(number*100) / 100;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers)
                .filter(number -> number % divider == 0)
                .toArray();
    }

    private double factorial(double n)
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

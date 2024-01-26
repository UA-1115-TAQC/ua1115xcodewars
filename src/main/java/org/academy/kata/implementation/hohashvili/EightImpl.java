package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Eight;

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
        return (double) Math.round(number*100) / 100;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
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

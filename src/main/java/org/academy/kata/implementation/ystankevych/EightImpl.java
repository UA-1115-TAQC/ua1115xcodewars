package org.academy.kata.implementation.ystankevych;

import org.academy.kata.Eight;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) (time / 2);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        final float litresPerGallon = 4.54609188f;
        final float kmPerMile = 1.609344f;
        return (float) Math.round(100 * (mpg * kmPerMile / litresPerGallon)) / 100;
    }

    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            final double squareRoot = Math.sqrt(array[i]);
            if (squareRoot == (int) squareRoot) {
                array[i] = (int) squareRoot;
            } else {
                array[i] *= array[i];
            }
        }
        return array;
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

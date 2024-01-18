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
        int[] newArray = new int[array.length];
        for (int i=0; i<array.length; i++) {
            double sqrt = Math.sqrt(array[i]);
            if (sqrt == Math.floor(sqrt)) {
                newArray[i] = (int)sqrt;
            } else {
                newArray[i] = array[i]*array[i];
            }
        }
        return newArray;
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

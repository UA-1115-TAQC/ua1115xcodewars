package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Eight;

import java.util.Arrays;

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
        return Eight.squareOrSquareRootStatic(array);
    }
    public static void main(String[] args) {
        EightImpl eightImpl = new EightImpl();
        int[] inputArray = {4, 3, 9, 7, 2, 1};
        int[] resultArray = eightImpl.squareOrSquareRoot(inputArray);
        System.out.println("Input Array: " + Arrays.toString(inputArray));
        System.out.println("Result Array: " + Arrays.toString(resultArray));
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

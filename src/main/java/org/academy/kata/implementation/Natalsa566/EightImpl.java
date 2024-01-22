package org.academy.kata.implementation.Natalsa566;

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
@Override
    public boolean am_i_wilson(double n) {
        long number = (long) n;
        if (number < 2) {
            return false;
        }
        double factorialMod = 1;
        for (double i = 2; i < n; i++) {
            factorialMod = (factorialMod * i) % n;
        }
        return (factorialMod + 1) % n == 0;
    }
    public static void main(String[] args) {
        Eight eight = new EightImpl();
        double num1 = 5.0;
        double num2 = 7.0;
        double num3 = 13.0;
        double num4 = 2.5;
        System.out.println(num1 + " is a Wilson prime: " + eight.am_i_wilson(num1));
        System.out.println(num2 + " is a Wilson prime: " + eight.am_i_wilson(num2));
        System.out.println(num3 + " is a Wilson prime: " + eight.am_i_wilson(num3));
        System.out.println(num4 + " is a Wilson prime: " + eight.am_i_wilson(num4));
    }
}


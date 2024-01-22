package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Eight;
import java.text.DecimalFormat;

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
    @Override
    public double TwoDecimalPlaces(double number) {
        long n = (long) number;
        if (n < 2 || n != number || number % 1 != 0) {
            return 0.0;
        }
        long factorialMod = 1;
        for (long i = 2; i < n; i++) {
            factorialMod = (factorialMod * i) % n;
        }
        double result = (factorialMod + 1) % (n * n) == 0 ? 1.0 : 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(result));
    }
    public static void main(String[] args) {
        Eight checker = new EightImpl();
        double num1 = 5.0;
        double num2 = 7.0;
        double num3 = 13.0;
        double num4 = 2.5;
        System.out.println(num1 + " is a Wilson prime: " + checker.TwoDecimalPlaces(num1));
        System.out.println(num2 + " is a Wilson prime: " + checker.TwoDecimalPlaces(num2));
        System.out.println(num3 + " is a Wilson prime: " + checker.TwoDecimalPlaces(num3));
        System.out.println(num4 + " is a Wilson prime: " + checker.TwoDecimalPlaces(num4));
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }

    public boolean am_i_wilson(double n) {
        return false;
    }
}

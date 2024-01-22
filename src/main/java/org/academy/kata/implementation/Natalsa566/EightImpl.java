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
        return Integer.parseInt(str);
    }
    public static void main(String[] args) {
        Eight converter = new EightImpl();
        String str1 = "1234";
        String str2 = "605";
        String str3 = "1405";
        String str4 = "-7";

        System.out.println(converter.stringToNumber(str1));
        System.out.println(converter.stringToNumber(str2));
        System.out.println(converter.stringToNumber(str3));
        System.out.println(converter.stringToNumber(str4));
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

package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Eight;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }
    public static void main(String[] args) {
        System.out.println(new EightImpl().liters(3));
        System.out.println(new EightImpl().liters(6.7));
        System.out.println(new EightImpl().liters(11.8));
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

    public boolean am_i_wilson(double n) {
        return false;
    }
}

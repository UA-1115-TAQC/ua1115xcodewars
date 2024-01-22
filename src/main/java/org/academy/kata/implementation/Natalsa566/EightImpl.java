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
        float gallonsToLiters = 4.54609188f;
        float milesToKilometers = 1.609344f;
        float kpm = (mpg * milesToKilometers) / gallonsToLiters;
        kpm = Math.round(kpm * 100.0) / 100.0f;
        return kpm;
    }
    public static void main(String[] args) {
        Eight converter = new EightImpl();
        float mpg = 35.0f;
        float kpm = converter.mpgToKPM(mpg);
        System.out.println(mpg + " mpg is equal to " + kpm + " kpm");
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

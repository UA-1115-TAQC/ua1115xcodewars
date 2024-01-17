package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Eight;

import java.text.DecimalFormat;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) (time * 0.5);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        float kpl = mpg * (float) 1.609344 / (float) 4.54609188;
        DecimalFormat df = new DecimalFormat("#.##"); // Форматування до двох знаків після коми
        return Float.parseFloat(df.format(kpl));
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

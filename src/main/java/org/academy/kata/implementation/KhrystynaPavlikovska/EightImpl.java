package org.academy.kata.implementation.KhrystynaPavlikovska;

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
        double gallonToLitres = 4.54609188;
        double mileToKilometer = 1.609344;

        double kpl = mileToKilometer / gallonToLitres;
        float mpgToKPM = (float) (kpl * mpg);

        DecimalFormat df = new DecimalFormat("#.##");
        return Float.parseFloat(df.format(mpgToKPM));
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

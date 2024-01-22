package org.academy.kata.implementation.nasock;

import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EightImpl implements Eight {
    private static float GALON_TO_LITERS = 4.54609188F;
    private static float MILE_TO_KM = 1.609344F;

    public int liters(double time) {
        if (time < 0) {
            throw new IllegalArgumentException();
        }
        return (int) time / 2;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }

        double volume  = length * width * height;
        BigDecimal bd = new BigDecimal(volume);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public float mpgToKPM(float mpg) {
        if (mpg < 0) {
            throw new IllegalArgumentException();
        }

        float kpl  = mpg * MILE_TO_KM / GALON_TO_LITERS;
        BigDecimal bd = BigDecimal.valueOf(kpl);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }

    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
    }

    public int stringToNumber(String str) {
        char[] chars = str.toCharArray();
        int num = 0;
        int i = 0;
        boolean isNegative = false;
        if (chars[0] == '-'){
            i = 1;
            isNegative = true;
        }
        for(; i < chars.length; i++){
            int currentNum = chars[i] - '0';
            num = num * 10 + currentNum;
        }
        if(isNegative){
            num = num * -1;
        }
        return num;
    }

    public double TwoDecimalPlaces(double number) {
        BigDecimal bd = BigDecimal.valueOf(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }

    public boolean am_i_wilson(double n) {
        return false;
    }
    
}

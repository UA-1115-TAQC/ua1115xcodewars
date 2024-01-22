package org.academy.kata.implementation.nasock;

import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EightImpl implements Eight {
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
        return 0;
    }

    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if(input == null || input.length == 0){
            return new int[]{};
        }

        int count = 0;
        int sum = 0;
        for(int num : input){
            if (num > 0){
                count++;
            } else if (num < 0){
                sum = sum + num;
            }
        }
        return new int[]{count, sum};
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

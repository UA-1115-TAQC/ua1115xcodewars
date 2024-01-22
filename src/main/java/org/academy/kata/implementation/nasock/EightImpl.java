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

    private boolean hasSqRt(int num){
        double sqrt = Math.sqrt(num);
        Double decimalPart = sqrt - (int)sqrt;
        return Double.valueOf(0.0).equals(decimalPart);
    }

    public int[] squareOrSquareRoot(int[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int num = array[i];
            if (hasSqRt(num)) {
                result[i] = (int) Math.sqrt(num);
            } else {
                result[i] = num*num;
            }
        }
        return result;
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

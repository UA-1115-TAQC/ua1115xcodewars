package org.academy.kata.implementation.nasock;

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

    private boolean hasSqRt(int num){
        double sqrt = Math.sqrt(num);
        Double decimalPart = (sqrt - (int)sqrt);
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

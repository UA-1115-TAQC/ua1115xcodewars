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

    private boolean isNatural(double num){
        double decimalPart = num - (int)num;
        return decimalPart == 0.0;
    }

    private int[] resizeArr(int[] arr, int newLength){
        int[] newArr = new int[newLength];
        for (int i = 0; i < newArr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        int[] result = new int[numbers.length];
        int j = 0;
        for(int num : numbers) {
            double div = num/(double)divider;
            if(isNatural(div)){
                result[j] = num;
                j++;
            }
        }
        int[] resized = resizeArr(result, j);
        return resized;
    }

    public boolean am_i_wilson(double n) {
        return false;
    }

}

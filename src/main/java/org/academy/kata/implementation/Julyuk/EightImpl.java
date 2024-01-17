package org.academy.kata.implementation.Julyuk;

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

        if(input != null && input.length != 0){
            int[] result = {0,0};
            for(int i = 0; i < input.length; i++){
                if(input[i] > 0){
                    result[0] += 1;
                } else if(input[i] < 0){
                    result[1] += input[i];
                }
            }
            return result;
        } else{
            return new int[]{};
        }
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

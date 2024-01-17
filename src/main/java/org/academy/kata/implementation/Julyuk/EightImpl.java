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
        return new int[0];
    }

    public int stringToNumber(String str) {
        return 0;
    }

    public double TwoDecimalPlaces(double number) {
        return 0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        if(numbers != null && divider != 0){
            int counter=0;
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] % divider == 0){
                    counter++;
                }
            }
            int [] result = new int[counter];
            counter = 0;
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] % divider == 0){
                    result[counter] = numbers[i];
                    counter++;
                }
            }
            return result;
        } else{
            throw new IllegalArgumentException();
        }
    }

    public boolean am_i_wilson(double n) {
        return false;
    }
}

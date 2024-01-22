package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Eight;

import java.lang.Math;

public class EightImpl implements Eight {
    public int liters(double time) {
        if (time > 0) {
            return (int) Math.floor(time * 0.5);
        }
        throw new IllegalArgumentException("Time must be a positive number");
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    public float mpgToKPM(float mpg) {
        final double IMPERIAL_GALLON = 4.54609188;
        final double MILE = 1.609344;
        if (mpg > 0 ) {
            return  Math.round(mpg * MILE * 100 / IMPERIAL_GALLON) /100.0f;
        }
        throw new IllegalArgumentException("The value must be positive");
    }

    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {

        if(input != null && input.length != 0){
            int[] result = {0,0};
            for (int j : input) {
                if (j > 0) {
                    result[0] += 1;
                } else if (j < 0) {
                    result[1] += j;
                }
            }
            return result;
        }
            return new int[]{};
    }

    public int stringToNumber(String str) {
        return Integer.valueOf(str);
    }

    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100) / 100.0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        if(numbers != null && divider != 0){
            int counter=0;
            for (int number : numbers) {
                if (number % divider == 0) {
                    counter++;
                }
            }
            int [] result = new int[counter];
            counter = 0;
            for (int number : numbers) {
                if (number % divider == 0) {
                    result[counter] = number;
                    counter++;
                }
            }
            return result;
        }
            throw new IllegalArgumentException();
    }

    public boolean am_i_wilson(double n) {
        return false;
    }
}

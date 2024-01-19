package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Eight;
import java.lang.Math;
import java.util.Arrays;
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
        if(array != null) {
            int [] resultArray = Arrays.copyOf(array, array.length);
            for(int elem = 0; elem < array.length; elem++){
                if(resultArray[elem] > 0 &&
                        (int) Math.sqrt(resultArray[elem]) * (int)  Math.sqrt(resultArray[elem]) == resultArray[elem]){
                    resultArray[elem] = (int) Math.sqrt(resultArray[elem]);
                } else{
                    resultArray[elem] *= resultArray[elem];
                }
            }
            return resultArray;
        }
            throw new IllegalArgumentException("The array must not be empty");
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

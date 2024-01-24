package org.academy.kata.implementation.Natalsa566;

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

    @Override
    public int[] countPositivesSumNegatives ( int[] input){
        if (input == null || input.length == 0) {
            return new int[0];
        }
            int countPositives = 0;
            int sumNegatives = 0;

               for (int num : input) {
                  if (num > 0) {
                     countPositives++;
                       } else if (num < 0) {
                            sumNegatives += num;
            }
        }
        return new int[]{countPositives, sumNegatives};
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

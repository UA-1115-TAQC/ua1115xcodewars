package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Eight;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

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
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        long n = (long) number;
        if (n < 2 || n != number || number % 1 != 0) {
            return 0.0;
        }
        long factorialMod = 1;
        for (long i = 2; i < n; i++) {
            factorialMod = (factorialMod * i) % n;
        }
        double result = (factorialMod + 1) % (n * n) == 0 ? 1.0 : 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(result));
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        List<Integer> result = new ArrayList<>();
             for (int number : numbers) {
                if (number % divider == 0) {
                    result.add(number);
            }
    }
                int[] resultArray = new int[result.size()];
                for (int i = 0; i < result.size(); i++) {
                    resultArray[i] = result.get(i);
                     }
                         return resultArray;
}
    public boolean am_i_wilson(double n) {
        long number = (long) n;
        if (number < 2) {
            return false;
        }
        double factorialMod = 1;
        for (double i = 2; i < n; i++) {
            factorialMod = (factorialMod * i) % n;
        }
        return (factorialMod + 1) % n == 0;
    }
}


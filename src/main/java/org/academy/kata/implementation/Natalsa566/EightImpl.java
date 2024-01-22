package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Eight;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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
           public static void main(String[] args) {
                 EightImpl eightImpl = new EightImpl();
                 int[] inputArray = {1, 2, 3, 4, 5, 6};
                 int divisor = 2;
                 int[] result = eightImpl.divisibleBy(inputArray, divisor);
                 System.out.println(Arrays.toString(result));
}
    public boolean am_i_wilson(double n) {
        return false;
    }
}

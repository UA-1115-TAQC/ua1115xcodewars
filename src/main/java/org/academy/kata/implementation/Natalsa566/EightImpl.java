package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Eight;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;



public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        double volume = length * width * height;
        return volume;
    }
    public float mpgToKPM(float mpg) {
        float gallonsToLiters = 4.54609188f;
        float milesToKilometers = 1.609344f;
        float kpm = (mpg * milesToKilometers) / gallonsToLiters;
        kpm = Math.round(kpm * 100.0) / 100.0f;
        return kpm;
    }

    public int[] squareOrSquareRoot(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            double squareRoot = Math.sqrt(number);
            result[i] = (squareRoot == (int) squareRoot) ? (int) squareRoot : (number * number);
        }
        return result;
    }

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
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        return Double.parseDouble(String.format("%.2f", number));
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
        ArrayList<Double> onlyKnownWilsonPrimes = new ArrayList<Double>();
        onlyKnownWilsonPrimes.add(5d);
        onlyKnownWilsonPrimes.add(13d);
        onlyKnownWilsonPrimes.add(563d);

        return onlyKnownWilsonPrimes.contains(n);
    }
}


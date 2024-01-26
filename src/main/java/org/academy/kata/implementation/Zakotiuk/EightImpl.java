package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Eight;

import java.text.DecimalFormat;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) (time * 0.5);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        float kpl = mpg * (float) 1.609344 / (float) 4.54609188;
        DecimalFormat df = new DecimalFormat("#.##"); // Форматування до двох знаків після коми
        return Float.parseFloat(df.format(kpl));
    }

    public int[] squareOrSquareRoot(int[] array) {
        double sqrt_result;
        for(int i = 0; i < array.length; ++i) {
            sqrt_result = Math.sqrt(array[i]);

            if(sqrt_result % 1 == 0) {
                array[i] = (int)sqrt_result;
            }
            else {
                array[i] = array[i] * array[i];
            }
        }
        return array;
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if(input == null || input.length == 0)
            return new int[] {};
        int positive_count = 0;
        int negative_summ = 0;
        for (int j : input) {
            if (j > 0) {
                positive_count++;
            } else {
                negative_summ += j;
            }
        }
        return new int[] {positive_count, negative_summ};
    }

    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        DecimalFormat decimal = new DecimalFormat("#.##");
        return Double.parseDouble(decimal.format(number));
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        int count = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int counter  = 0;

        for (int number : numbers) {
            if (number % divider == 0) {
                result[counter] = number;
                counter++;
            }
        }
        return result;
    }
    public boolean am_i_wilson(double n) {
        long sqr = (long) (n * n);
        long item = 1;
        for (long factor = 2; factor < n; factor++)
            item = (item * factor) % sqr;
        return item + 1 == sqr;
    }
}

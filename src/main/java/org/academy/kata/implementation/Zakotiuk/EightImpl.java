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
        for(int i = 0; i < input.length; ++i){
            if(input[i] > 0){
                positive_count++;
            }
            else{
                negative_summ+= input[i];
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
        return new int[0];
    }

    public boolean am_i_wilson(double n) {
        return false;
    }
}

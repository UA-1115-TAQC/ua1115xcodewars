package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Eight;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.math.BigInteger;
import java.lang.Math;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int)(time / 2);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        double gallonToLitres = 4.54609188;
        double mileToKilometer = 1.609344;

        double kpl = mileToKilometer / gallonToLitres;
        float mpgToKPM = (float) (kpl * mpg);

        DecimalFormat df = new DecimalFormat("#.##");
        return Float.parseFloat(df.format(mpgToKPM));
    }

    public int[] squareOrSquareRoot(int[] array) {
        int[] array2 = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int sqrt = (int) Math.sqrt(num);

            array2[i] = (sqrt * sqrt == num) ? sqrt : num * num;
        }

        return array2;
    }

    public int[] countPositivesSumNegatives(int[] input) {

        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countPositives = 0;
        int sumNegatives = 0;

       // for (int i = 0; i < input.length; i++) {
       //     int num = input[i];
        for (int num : input) {
            if (num > 0) {
                countPositives++;
            }
            else if (num < 0) {
                sumNegatives += num;
            }
        }

        return new int[] {countPositives, sumNegatives};
    }

    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers)
                .filter(number -> number % divider == 0)
                .toArray();
    }

    public boolean am_i_wilson(double n) {

        if (n == 0 || n == 1) {
            return false;
        }

        for (int divisor = 2; divisor * divisor <= (n / 2); divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }

        BigInteger factorial = BigInteger.ONE;
        for (long i = 2; i <= n - 1; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger wilsonCondition = factorial.add(BigInteger.ONE)
                .mod(BigInteger.valueOf((long) (n * n)));
        return wilsonCondition.equals(BigInteger.ZERO);
    }

}

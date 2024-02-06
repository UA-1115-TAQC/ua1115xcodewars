package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Base;
import org.academy.kata.Eight;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class EightImpl extends Base implements Eight {
    public static final float ONE_IMPERIAL_GALLON = 4.54609188f;
    public static final float ONE_KM = 1.609344f;

    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        return (float) Math.round(mpg * ONE_KM / ONE_IMPERIAL_GALLON * 100) / 100;
    }

    public int[] squareOrSquareRoot(int[] array) {
        return IntStream.of(array)
                .map(x -> (int) (Math.sqrt(x) == (int) Math.sqrt(x)
                        ? Math.sqrt(x) : Math.pow(x, 2)))
                .toArray();
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }

        int negativeSum = IntStream.of(input).filter(x -> x < 0).sum();
        int quantityOfPositiveNumbers = (int) IntStream.of(input).filter(x -> x > 0).count();
        return new int[]{quantityOfPositiveNumbers, negativeSum};
    }

    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return IntStream.of(numbers)
                .filter(x -> x % divider == 0)
                .toArray();
    }

    public boolean am_i_wilson(double n) {
        BigInteger factorial = BigInteger.ONE;
        BigInteger value = BigInteger.valueOf((long) n);

        for (int i = 1; i <= n - 1; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger addDigitToFactorial = factorial.add(BigInteger.ONE);
        BigInteger sqrtOfN = value.multiply(value);

        return addDigitToFactorial.mod(sqrtOfN).equals(BigInteger.ZERO);
    }
}

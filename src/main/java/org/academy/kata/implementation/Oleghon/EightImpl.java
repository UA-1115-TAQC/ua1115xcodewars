package org.academy.kata.implementation.Oleghon;

import org.academy.kata.Eight;

import java.util.stream.*;
import java.math.*;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) Math.floor(time / 2);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length > 0 && width > 0 && height > 0? length * width * height : 0;
    }

    public float mpgToKPM(float mpg) {
        final var GALLON_TO_LITRE = 4.54609188f;
        final var MILE_TO_KILOMETER = 1.609344f;
        return Float.parseFloat(String.format("%.2f", mpg * MILE_TO_KILOMETER / GALLON_TO_LITRE));
    }

    public int[] squareOrSquareRoot(int[] array) {
        final var resultArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArr[i] = (int) (Math.sqrt(array[i]) % 1 == 0 ? Math.sqrt(array[i]) : Math.pow(array[i], 2));
        }
        return resultArr;
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int sum = 0, count = 0;

        for (int elem : input) {
            if (elem > 0) count++;
            if (elem < 0) sum += elem;
        }
        return new int[]{count, sum};
    }

    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return IntStream.of(numbers)
                .filter(n -> n % divider == 0)
                .toArray();
    }

    public boolean am_i_wilson(double n) {
        if (n <= 1) return false;

        long longN = (long) n;
        return LongStream.range(2, longN)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply)
                .add(BigInteger.ONE)
                .divideAndRemainder(BigInteger.valueOf(longN * longN))[1]
                .intValue() == 0;
    }
}

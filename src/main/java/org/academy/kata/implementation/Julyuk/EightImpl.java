package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Eight;
import java.lang.Math;
import java.math.BigInteger;

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
        return new int[0];
    }

    public boolean am_i_wilson(double n) {

        if (n == 1 || n == 0) {
            return false;
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

        }

        BigInteger factorial = BigInteger.ONE;
        for (long i = 2; i < n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger result = factorial.add(BigInteger.ONE).mod(BigInteger.valueOf((long) (n * n)));
        return result.equals(BigInteger.ZERO);
    }
}

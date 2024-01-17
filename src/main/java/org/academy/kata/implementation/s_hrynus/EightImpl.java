package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Eight;

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

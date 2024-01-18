package org.academy.kata.implementation.OksankaV;

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

    private static BigInteger factorial(int n) {
        return (n == 0 || n == 1) ? BigInteger.ONE : BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    private static boolean isPrime(int n) {
        if (n <= 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean am_i_wilson(double n) {
        int nInt = (int) n;
        if (isPrime(nInt)) {
            BigInteger a = factorial(nInt - 1).add(BigInteger.ONE);
            BigInteger b = BigInteger.valueOf(nInt).multiply(BigInteger.valueOf(nInt));
            return a.mod(b).equals(BigInteger.ZERO);
        } else {
            return false;
        }
    }
}

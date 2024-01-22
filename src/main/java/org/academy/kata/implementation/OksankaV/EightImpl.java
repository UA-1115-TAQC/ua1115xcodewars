package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Eight;
import java.util.Arrays;

import java.math.BigInteger;

public class EightImpl implements Eight {
    public int liters(double time) {
        return (int)(time / 2);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        float galonToLiter = 4.54609188f;
        float mileToKm = 1.609344f;
        return (float) Math.round(mpg * mileToKm / galonToLiter * 100) / 100;
    }

    public int[] squareOrSquareRoot(int[] array) {
        int[] newArray = new int[array.length];
        for (int i=0; i<array.length; i++) {
            double sqrt = Math.sqrt(array[i]);
            if (sqrt == Math.floor(sqrt)) {
                newArray[i] = (int)sqrt;
            } else {
                newArray[i] = array[i]*array[i];
            }
        }
        return newArray;
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if (input != null && input.length != 0) {
            int countPositive = 0;
            int sumNegative = 0;
            for (int value : input) {
                if (value > 0) countPositive++;
                else if (value < 0) sumNegative += value;
            }
            int[] arr = {countPositive,sumNegative};
            return arr;
        } else
            return new int[0];
    }

    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100d) / 100d;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers).filter(value -> value % divider == 0).toArray();
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

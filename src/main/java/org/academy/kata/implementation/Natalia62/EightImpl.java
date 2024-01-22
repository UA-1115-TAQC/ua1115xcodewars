package org.academy.kata.implementation.Natalia62;

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
        for (int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) array[i] = (int) Math.sqrt(array[i]);
            else array[i] = (int) Math.pow(array[i],2);
        }
        return array;
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
        if (n <= 2) return false;
        BigInteger factorial = BigInteger.ONE;
        BigInteger number =  BigInteger.valueOf((long) n);

        for (int i = 1; i < n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));}
        BigInteger Newfactorial = factorial.add(BigInteger.ONE);
        BigInteger pow = number.multiply(number);
        return Newfactorial.mod(pow).equals(BigInteger.ZERO);
    }
}

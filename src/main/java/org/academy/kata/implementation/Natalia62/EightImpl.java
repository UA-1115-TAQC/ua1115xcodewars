package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Eight;
import java.math.BigInteger;
public class EightImpl implements Eight {
    public int liters(double time) {
        return (int) (time*0.5);
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    public float mpgToKPM(float mpg) {
        double MileToKilo = 1.609344;
        double GallonToLiter = 4.54609188;
        return (float) (mpg * MileToKilo / GallonToLiter);
    }

    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) array[i] = (int) Math.sqrt(array[i]);
            else array[i] = (int) Math.pow(array[i],2);
        }
        return array;
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if (input != null && input.length != 0) {
            int Pos = 0;
            int Neg = 0;
            for (int num : input) {
                if (num > 0) Pos += 1;
                else Neg += num;
            }
            return new int[]{Pos, Neg};
        }
        else return new int[]{};
    }

    public int stringToNumber(String str) {
        return 0;
    }

    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100d) / 100d;
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

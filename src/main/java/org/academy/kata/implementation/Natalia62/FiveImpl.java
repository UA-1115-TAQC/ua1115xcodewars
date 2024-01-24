package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    public int zeros(int n) {
        return 0;
    }

    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            sum = sum.add(a.multiply(BigInteger.valueOf(4)));

            BigInteger newfib = a.add(b);
            a = b;
            b = newfib;
        }

        return sum;
    }

    public double solve(double m) {
        return (2 * m + 1 - Math.sqrt(4 * m + 1)) / (2 * m);
    }

    public long[] smallest(long n) {
        String numberStr = String.valueOf(n);
        long smallestNum = n;
        int digitIndex = 0;
        int insertIndex = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            char digit = numberStr.charAt(i);

            StringBuilder modifiedNumber = new StringBuilder(numberStr);
            modifiedNumber.deleteCharAt(i);

            for (int j = 0; j <= modifiedNumber.length(); j++) {
                StringBuilder temp = new StringBuilder(modifiedNumber);
                temp.insert(j, digit);

                long modifiedLong = Long.parseLong(temp.toString());

                if (modifiedLong < smallestNum) {
                    smallestNum = modifiedLong;
                    digitIndex = i;
                    insertIndex = j;
                }
            }
        }

        return new long[]{smallestNum, digitIndex, insertIndex};
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

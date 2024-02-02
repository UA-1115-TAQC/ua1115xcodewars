package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    private static boolean isPrime(long i) {
        if (i < 2) return false;
        for (long j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    public long[] gap(int g, long m, long n) {
        long prevPrime = 0;
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (i - prevPrime == g) return new long[]{prevPrime, i};
                prevPrime = i;
            }
        }
        return null;
    }

    public int zeros(int n) {
        int zeros = 0;
        while (n >= 5) {
            n /= 5;
            zeros += n;
        }
        return zeros;
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
}

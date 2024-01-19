package org.academy.kata.implementation.Julyuk;

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
        if (n.compareTo(BigInteger.ZERO) > 0) {
            BigInteger start1 = BigInteger.ZERO;
            BigInteger start2 = BigInteger.ONE;

            BigInteger fibo;
            BigInteger squares = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
                fibo = start1.add(start2);
                start1 = start2;
                start2 = fibo;
                squares = squares.add(fibo);
            }

            return squares.multiply(BigInteger.valueOf(4));
        }
        return BigInteger.ZERO;
    }

    public double solve(double m) {
        return 0;
    }

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

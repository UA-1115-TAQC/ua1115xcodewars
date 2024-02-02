package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    public int zeros(int n) {
        int count = 0;

        while (n >= 5) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger temp = b;
            b = b.add(a);
            a = temp;
            sum = sum.add(b);
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    public double solve(double m) {
        double squareRootTerm = Math.sqrt(4 * m + 1);
        return (1 - squareRootTerm) / (2 * m) + 1;
    }

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    public int zeros(int n) {
        int counterOfZeroes = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            counterOfZeroes += n / i;
        }
        return counterOfZeroes;
    }

    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;
        BigInteger d = BigInteger.TWO;
        for (int i = 1; i <= n.intValue(); i++) {
            d = d.add(c);
            c = a.add(b);
            a = b;
            b = c;
        }
        return d.multiply(BigInteger.valueOf(4));
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

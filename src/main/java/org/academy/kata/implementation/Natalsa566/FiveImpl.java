package org.academy.kata.implementation.Natalsa566;

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
        return null;
    }

    public double solve(double m) {
        if (m <= 0 || m >= 1) {
            throw new IllegalArgumentException("m should be in the range (0, 1)");
        }
        double x = m / 2.0;
        for (int i = 0; i < 1000; i++) {
            double numerator = m * x;
            double denominator = 1 + x;
            double newX = numerator / denominator;
            if (Math.abs(newX - x) < 1e-13) {
                return newX;
            }
            x = newX;
        }
        return x;
    }

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

package org.academy.kata.implementation.Zakotiuk;

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
        double left = 0;
        double right = 1, arv;
        double accuracy = 1e-12;
        while (right - left > accuracy) {
            arv = (left + right) / 2;
            double u = arv / Math.pow(1 - arv, 2);
            if (u > m) {
                right = arv;
            } else {
                left = arv;
            }
        }
        return (left + right) / 2;
    }

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

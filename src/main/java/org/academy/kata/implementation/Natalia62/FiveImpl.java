package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
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

    private static boolean isPrime(long i) {
        if (i < 2) return false;
        for (long j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }
        return true;
    }


    public int zeros(int n) {
        return 0;
    }

    public BigInteger perimeter(BigInteger n) {
        return null;
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

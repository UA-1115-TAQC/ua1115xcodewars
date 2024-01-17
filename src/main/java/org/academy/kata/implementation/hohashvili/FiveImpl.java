package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {


    private static boolean isPrime(long num) {
        if (num < 2) { return false; }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public long[] gap(int g, long m, long n) {
        long prevNum = 0;
        long[] result = {0,0};
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (i - prevNum == g) {
                    result = new long[]{prevNum, i};
                    return result;
                }
                prevNum = i;
            }
        }
        return null;
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

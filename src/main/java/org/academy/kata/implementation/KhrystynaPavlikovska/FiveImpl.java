package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Five;

import java.util.Arrays;
import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {

        long[] result = new long[2];

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                long nextPrime = findNextPrime(i + 1, n);
                if (nextPrime - i == g) {
                    result[0] = i;
                    result[1] = nextPrime;
                    return result;
                }
            }
        }

        return null;
    }

    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long findNextPrime(long start, long limit) {
        for (long i = start; i <= limit; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1;
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

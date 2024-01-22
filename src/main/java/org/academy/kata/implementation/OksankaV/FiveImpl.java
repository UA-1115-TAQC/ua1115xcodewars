package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    private static boolean isPrime(long n) {
        if ((n <= 2) || (n % 2 == 0)) return false;
        for (long i = 3; i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public long[] gap(int g, long m, long n) {
        long currentPrime = 0;
        long nextPrime = 0;
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                currentPrime = nextPrime;
                nextPrime = i;
            }
            if (nextPrime - currentPrime == g) {
                return new long[]{currentPrime, nextPrime};
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
        double sqrt = Math.sqrt(4 * m + 1);
        return (1 - sqrt) / (2 * m) + 1;
    }

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

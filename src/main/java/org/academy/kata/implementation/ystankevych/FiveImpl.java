package org.academy.kata.implementation.ystankevych;

import org.academy.kata.Five;
import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        if (g < 2 || g % 2 != 0 || m <= 2 || n < m) {
            return null;
        }

        long temp = 0;

        for (long i = m % 2 == 0 ? m + 1 : m; i < n; i += 2) {
            if (isPrime(i)) {
                if (i - temp == g) {
                    return new long[] {temp, i};
                }
                temp = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long value) {
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
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

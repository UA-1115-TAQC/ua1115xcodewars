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
        return n < 5 ? 0 : n / 5 + zeros(n / 5);
    }

    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    public double solve(double m) {
        return (1 - Math.sqrt(4 * m + 1)) / (2 * m) + 1;
    }

    public long[] smallest(long n) {
        long[] result = {n, 0, 0};
        StringBuilder sb = new StringBuilder().append(n);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            for (int j = 0; j < sb.length(); j++) {
                if (i != j) {
                    sb.deleteCharAt(i).insert(j, c);
                    if (Long.parseLong(sb.toString()) < result[0]) {
                        result[0] = Long.parseLong(sb.toString());
                        result[1] = i;
                        result[2] = j;
                    }
                    sb.deleteCharAt(j).insert(i, c);
                }
            }
        }
        return result;
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

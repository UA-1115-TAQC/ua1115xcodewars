package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        long last = Long.MIN_VALUE;
        for (long i = m; i < n; i++) {
            if (isPrime(i)) {
                if (i - last == g) {
                    return new long[]{last, i};
                }
                last = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long i) {
        for (long j = 2; j < i / 2; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    public int zeros(int n) {
        int zeros = 0;
        while (n >= 5) {
            n /= 5;
            zeros += n;
        }
        return zeros;
    }

    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger temp;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i <= n.intValue(); i++) {
            sum = sum.add(b.multiply(BigInteger.valueOf(4)));
            temp = a.add(b);
            a = b;
            b = temp;
        }

        return sum;
    }

    public double solve(double m) {
        return (2 * m + 1 - Math.sqrt(4 * m + 1)) / (2 * m);
    }

    public long[] smallest(long n) {
        String s = Long.toString(n);
        long min1 = n, from1 = 0, to1 = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder removed = new StringBuilder(s.substring(0, i) + s.substring(i + 1));
            for (int j = 0; j <= removed.length(); j++) {
                long num = Long.parseLong(removed.insert(j, s.charAt(i)).toString());
                if (num < min1) {
                    min1 = num;
                    from1 = i;
                    to1 = j;
                }
                removed.deleteCharAt(j);
            }
        }
        return new long[]{min1, from1, to1};
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

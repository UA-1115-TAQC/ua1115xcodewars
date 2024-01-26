package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        for (long i = m; i <= n - g; i++) {
            if (isPrime(i) && isPrime(i + g)) {
                return new long[]{i, i + g};
            }
        }
        return null;
    }
    private static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int zeros(int n) {
        return 0;
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

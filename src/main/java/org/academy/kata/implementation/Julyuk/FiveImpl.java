package org.academy.kata.implementation.Julyuk;

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
        return 0;
    }

    private static long insertDigit(long num, int from, int to) {
        String numStr = Long.toString(num);
        StringBuilder result = new StringBuilder(numStr);
        char digit = result.charAt(from);
        result.deleteCharAt(from);
        result.insert(to, digit);
        return Long.parseLong(result.toString());
    }
    public long[] smallest(long n) {
        if (n > 0) {
            String numStr = Long.toString(n);
            int length = numStr.length();
            long minNum = n;
            long[] result = new long[]{n, 0, 0};
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    long currentNum = insertDigit(n, i, j);
                    if (currentNum < minNum) {
                        minNum = currentNum;
                        result[0] = minNum;
                        result[1] = i;
                        result[2] = j;
                    }
                }
            }
            return result;
        }
        throw new IllegalArgumentException();
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

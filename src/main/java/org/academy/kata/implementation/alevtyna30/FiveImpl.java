package org.academy.kata.implementation.alevtyna30;

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

    public long[] smallest(long n) {
        long min = n;
        int index1 = 0;
        int index2 = 0;
        String number = String.valueOf(n);
        for (int i = 0; i < number.length(); i++) {
            for (int j = 0; j < number.length(); j++) {
                if (i != j && makingSmallNumber(number, i, j) < min) {
                    min = makingSmallNumber(number, i, j);
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return new long[]{min, index1, index2};
    }

    private long makingSmallNumber(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(i);
        sb.deleteCharAt(i);
        sb.insert(j, c);

        return Long.parseLong(sb.toString());
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

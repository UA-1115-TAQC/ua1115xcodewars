package org.academy.kata.implementation.ystankevych;

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

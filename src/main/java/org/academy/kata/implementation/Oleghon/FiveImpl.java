package org.academy.kata.implementation.Oleghon;

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
        long small = n, delPos = 0, insPos = 0;
        var stringBuilder = new StringBuilder().append(n);
        int length = stringBuilder.length();

        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                char character = stringBuilder.charAt(i);
                long temp = 0;
                stringBuilder.deleteCharAt(i).insert(j, character);

                if ((temp = Long.parseLong(stringBuilder.toString())) < small) {
                    small = temp;
                    delPos = i;
                    insPos = j;
                }
                stringBuilder.deleteCharAt(j).insert(i, character);
            }
        return new long[]{small, delPos, insPos};
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

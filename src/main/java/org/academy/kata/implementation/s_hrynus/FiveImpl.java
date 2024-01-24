package org.academy.kata.implementation.s_hrynus;

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
        String value = String.valueOf(n);
        String smallestPossibleValue = value;
        int smallestDigitByIndex = 0;
        int replacedIndex = 0;

        for (int i = 0; i < value.length(); i++) {
            char currentDigit = value.charAt(i);
            for (int j = 0; j < value.length(); j++) {
                StringBuilder valueBuilder = new StringBuilder(value);
                valueBuilder.deleteCharAt(i);
                valueBuilder.insert(j, currentDigit);
                String valueAfterReplacing = valueBuilder.toString();
                if (Long.parseLong(valueAfterReplacing, 10) < Long.parseLong(smallestPossibleValue, 10)) {
                    smallestPossibleValue = valueAfterReplacing;
                    smallestDigitByIndex = i;
                    replacedIndex = j;
                }
            }
        }
        return new long[]{Long.parseLong(smallestPossibleValue), smallestDigitByIndex, replacedIndex};
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

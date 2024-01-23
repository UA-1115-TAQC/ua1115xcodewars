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
        var sum = BigInteger.ONE;
        var index = BigInteger.ONE;
        var current = BigInteger.ONE;
        var previous = BigInteger.ZERO;
        n = n.add(index);

        while (n.compareTo(index) > 0) {
            var temp = previous;
            previous = current;
            current = current.add(temp);
            sum = sum.add(current);
            index = index.add(BigInteger.ONE);
        }
        return sum.multiply(BigInteger.valueOf(4));
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

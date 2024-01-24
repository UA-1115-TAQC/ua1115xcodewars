package org.academy.kata.implementation.Oleghon;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        LongPredicate prime = l -> BigInteger.valueOf(l).isProbablePrime(9);
        return LongStream.range(m, n - g)
                .filter(i -> prime.test(i)
                        && prime.test(i + g)
                        && LongStream.range(i + 1, i + g).noneMatch(prime))
                .mapToObj(i -> new long[]{i, i + g})
                .findFirst()
                .orElse(null);
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

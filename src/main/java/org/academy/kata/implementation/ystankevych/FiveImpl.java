package org.academy.kata.implementation.ystankevych;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.academy.kata.Five;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    public int zeros(int n) {
        return 0;
    }

    public BigInteger perimeter(BigInteger n) {
        return Stream.iterate(new BigInteger[]{ONE, ONE}, i -> new BigInteger[]{i[1], i[0].add(i[1])})
                .limit(n.longValue()).map(a -> a[1]).reduce(ZERO, BigInteger::add).add(ONE).multiply(BigInteger.valueOf(4));
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

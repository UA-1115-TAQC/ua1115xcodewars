package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.function.LongPredicate;

import static java.util.stream.LongStream.range;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        LongPredicate prime = l -> BigInteger.valueOf(l).isProbablePrime(9);
        return range(m, n - g)
                .filter(i -> prime.test(i) && prime.test(i + g) && range(i + 1, i + g).noneMatch(prime))
                .mapToObj(i -> new long[]{i, i + g}).findFirst().orElse(null);
    }

    public int zeros(int n) {
        int counterOfZeroes = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            counterOfZeroes += n / i;
        }
        return counterOfZeroes;
    }

    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;
        BigInteger d = BigInteger.TWO;
        for (int i = 1; i <= n.intValue(); i++) {
            d = d.add(c);
            c = a.add(b);
            a = b;
            b = c;
        }
        return d.multiply(BigInteger.valueOf(4));
    }

    public double solve(double m) {
        double sqrt = Math.sqrt(4 * m + 1);
        return (2 * m + 1 - sqrt) / (2 * m);
    }

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

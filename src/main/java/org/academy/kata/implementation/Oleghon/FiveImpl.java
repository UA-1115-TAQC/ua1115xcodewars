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
        return (2 * m + 1 - Math.sqrt(4 * m + 1)) / (2 * m);
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

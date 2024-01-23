package org.academy.kata.implementation.Zakotiuk;

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

        BigInteger future;
        BigInteger sum = BigInteger.ZERO;
        BigInteger counter = BigInteger.ZERO;
        BigInteger past_past = BigInteger.ONE;
        for(BigInteger i = BigInteger.ONE; i.compareTo(n.add(BigInteger.ONE)) <= 0; i = i.add(BigInteger.ONE)){
            future = counter.add(past_past);
            sum = sum.add(future);
            past_past = counter;
            counter = future;
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

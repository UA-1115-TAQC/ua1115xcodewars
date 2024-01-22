package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        long firstPrime = 0;
        long secondPrime = 0;
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                firstPrime = secondPrime;
                secondPrime = i;
            }
            if (secondPrime - firstPrime == g) return new long[]{firstPrime, secondPrime};
        }
        return null;
        }
    private static boolean isPrime(long n) {
        if (n <= 2) return false;
            for (long i = 3; i < n; i += 2) {
                if (n % i == 0) return false;
        }
        return true;
    }




    public int zeros(int n) {
        return 0;
    }

    public BigInteger perimeter(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) > 0) {
            BigInteger start1 = BigInteger.ZERO;
            BigInteger start2 = BigInteger.ONE;

            BigInteger fibo;
            BigInteger squares = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
                fibo = start1.add(start2);
                start1 = start2;
                start2 = fibo;
                squares = squares.add(fibo);
            }

            return squares.multiply(BigInteger.valueOf(4));
        }
        return BigInteger.ZERO;
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

package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.lang.Math;
public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        long firstPrime = 0, secondPrime = 0;
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
        for (long i = 3; i < n; i += 2) if (n % i == 0) return false;
        return true;
    }




    public int zeros(int n) {
        int fives = 0;
        while (n > 0) {
            n = (int) (double) (n / 5);
            fives += n;
        }
        return fives;
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
        if(m > 0){
        /*
    U(n, x) = x + 2x**2 + 3x**3 + .. + nx**n | with lim n->infinity
    <=> sum n*x^n, n=1 to infinity           | series representation
    <=> x/(x-1)^2 // got x from the series representation???

    Solve for equality with m:
    x/(x-1)^2 = m | made the previous expression to equal m, then we need transform it to isolate x
    <=> x = (2m - Math.sqrt(4m + 1) + 1)/(2m) //positive square root from the quadratic equation , as 0<x<1
  */
            return (2*m - Math.sqrt(4*m + 1) + 1)/(2*m);
        }
        throw new IllegalArgumentException();
    }

    private static long insertDigit(long num, int from, int to) {
        String numStr = Long.toString(num);
        StringBuilder result = new StringBuilder(numStr);
        char digit = result.charAt(from);
        result.deleteCharAt(from);
        result.insert(to, digit);
        return Long.parseLong(result.toString());
    }
    public long[] smallest(long n) {
        if (n > 0) {
            String numStr = Long.toString(n);
            int length = numStr.length();
            long minNum = n;
            long[] result = new long[]{n, 0, 0};
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    long currentNum = insertDigit(n, i, j);
                    if (currentNum < minNum) {
                        minNum = currentNum;
                        result[0] = minNum;
                        result[1] = i;
                        result[2] = j;
                    }
                }
            }
            return result;
        }
        throw new IllegalArgumentException();
    }

}

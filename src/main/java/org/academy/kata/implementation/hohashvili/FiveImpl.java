package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {


    private static boolean isPrime(long num) {
        if (num < 2) { return false; }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public long[] gap(int g, long m, long n) {
        long prevNum = 0;
        long[] result = {0,0};
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (i - prevNum == g) {
                    result = new long[]{prevNum, i};
                    return result;
                }
                prevNum = i;
            }
        }
        return null;
    }

    public int zeros(int n) {
        int count = 0;
        // if divisible by 5 -> 0 present
        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public BigInteger perimeter(BigInteger n) {
        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        BigInteger sum = BigInteger.ONE;

        for (int i = 2; i <= n.intValue()+1 ; i++) {
            BigInteger temp = current;
            current = prev.add(current);
            prev = temp;
            sum = sum.add(current);
        }

        // Multiply sum by 4 to get the total perimeter
        return sum.multiply(BigInteger.valueOf(4));
    }

    public double solve(double m) {
        double s =  Math.sqrt(4 * m + 1);
        return (1 - s) / (2 * m) + 1;

    }

    public long[] smallest(long n) {
        String nStr = String.valueOf(n);
        long smallest = n;
        long iNum = 0;
        long jNum = 0;

        for (int i = 0; i < nStr.length(); i++) {
            for (int j = 0; j < nStr.length(); j++) {
                if (i==j) {
                    continue;
                }
                String newStr = nStr.substring(0, i) + nStr.substring(i+1);
                newStr = newStr.substring(0,j) + nStr.charAt(i) + newStr.substring(j);
                if (Long.parseLong(newStr) < smallest) {
                    smallest = Long.parseLong(newStr);
                    iNum = i;
                    jNum = j;
                }
            }
        }
        return new long[]{smallest, iNum, jNum};
    }

}

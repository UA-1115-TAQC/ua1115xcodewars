package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    private static boolean isPrime(long n) {
        if ((n <= 2) || (n % 2 == 0)) return false;
        for (long i = 3; i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public long[] gap(int g, long m, long n) {
        long currentPrime = 0;
        long nextPrime = 0;
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                currentPrime = nextPrime;
                nextPrime = i;
            }
            if (nextPrime - currentPrime == g) {
                return new long[]{currentPrime, nextPrime};
            }
        }
        return null;
    }

    public int zeros(int n) {
        int countZero = 0;
        int k = 5;
        while (n / k > 0) {
            countZero += n / k;
            k *= 5;
        }
        return countZero;
    }

    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    public double solve(double m) {
        double sqrt = Math.sqrt(4 * m + 1);
        return (1 - sqrt) / (2 * m) + 1;
    }

    public long[] smallest(long n) {
        long[] resultArr = new long[]{n, 0, 0};
        String nStr = Long.toString(n);
        for (int i = nStr.length() - 1; i >= 0; i--) {
            String str = nStr.substring(0, i) + nStr.substring(i + 1);
            for (int j = nStr.length() - 1; j >= 0; j--) {
                long tempVal = Long.valueOf(str.substring(0, j) + nStr.charAt(i) + str.substring(j));
                if (resultArr[0] >= tempVal)
                    resultArr = new long[]{tempVal, i, j};
            }
        }
        return resultArr;
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

package org.academy.kata.implementation.nasock;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    private boolean isPrime(long n){
        for(long i = 2; i <= Math.sqrt(n); i++){
            long d = n % i;
            if (d == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean noPrimesBetween(long m, long n){
        for(long i = m+1; i < n; i++){
            if(isPrime(i)){
                return false;
            }
        }
        return true;
    }
    
    public long[] gap(int g, long m, long n) {
        for(long i = m; i <= n-g; i++){
            long pair = i + g;
            if(isPrime(i) && isPrime(pair) && noPrimesBetween(i, pair)){
                return new long[]{i, pair};
            }
        }
        return null;
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

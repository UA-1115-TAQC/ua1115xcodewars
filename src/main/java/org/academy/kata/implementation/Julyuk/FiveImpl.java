package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.lang.Math;
public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    public int zeros(int n) {
        return 0;
    }

    public BigInteger perimeter(BigInteger n) {
        return null;
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

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

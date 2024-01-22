package org.academy.kata.implementation.nasock;

import org.academy.kata.Five;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

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

    private BigInteger getFibonacciByN(BigInteger n){
//        use Binet's formula to find F(n)
        MathContext mc = new MathContext(10);
        BigDecimal sqrtOf5 = new BigDecimal(5).sqrt(mc);
        BigDecimal num1 = new BigDecimal(1);
        BigDecimal num2 = new BigDecimal(2);
        int nInt = n.intValue();

        BigDecimal bd1 = num1.add(sqrtOf5).divide(num2, RoundingMode.HALF_UP).pow(nInt);
        BigDecimal bd2 = num1.subtract(sqrtOf5).divide(num2, RoundingMode.HALF_UP).pow(nInt);
        BigDecimal bd3 = bd1.subtract(bd2).divide(sqrtOf5, RoundingMode.HALF_UP);
        BigDecimal fn = bd3.setScale(0, RoundingMode.HALF_UP);
        return fn.toBigInteger();
    }

    public BigInteger perimeter(BigInteger n) {
        BigInteger fibNum = getFibonacciByN(n.add(BigInteger.valueOf(3)));
        return fibNum.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(4));
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

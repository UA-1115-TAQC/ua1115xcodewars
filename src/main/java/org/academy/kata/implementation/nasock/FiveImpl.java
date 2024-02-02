package org.academy.kata.implementation.nasock;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class FiveImpl extends Base implements Five {
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
        int zeroCount = 0;
        while(n > 4){
            n = n / 5;
            zeroCount = zeroCount + n;
        }
        return zeroCount;
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
        double sqrtD = Math.sqrt(4 * m + 1);
        return (2 * m + 1 - sqrtD) / (2 * m);
    }

    private int findLastSmallestDigit (char[] digits){
        char lastSmallestDigit = '9';
        int lastSmallestDigitIndx = 0;
        for(int i = 1; i < digits.length; i++){
            char digit = digits[i];
            if(digit <= lastSmallestDigit){
                lastSmallestDigit = digit;
                lastSmallestDigitIndx = i;
            }
//            check the first digit is not choosen as the smallest
            if (i == digits.length - 1 && lastSmallestDigitIndx == digits[0]){
                i = lastSmallestDigitIndx;
            }
        }
        return lastSmallestDigitIndx;
    }

    private int findLeftestBiggerDigit (char[] digits, int indexOfSmallest){
        char smllestDigit = digits[indexOfSmallest];
        for(int i = 0; i < indexOfSmallest; i++){
            char digit = digits[i];
            if(digit > smllestDigit){
                return i;
            }
        }
        return -1;
    }

    private long[] movefSmallest(char[] digits, int indexOfSmallest, int indexOfBigger){
        char[] result = new char[digits.length];
        int index = 0;
        for(; index < indexOfBigger; index++ ){
            result[index] = digits[index];
        }
        result[index] = digits[indexOfSmallest];
        for(; index < indexOfSmallest; index++ ){
            result[index+1] = digits[index];
        }
        index++;
        for(; index < digits.length; index++ ){
            result[index] = digits[index];
        }
        if(Math.abs(indexOfBigger- indexOfSmallest) == 1){
            return new long[] {Long.parseLong(new String(result)), indexOfBigger, indexOfSmallest};
        }
        return new long[] {Long.parseLong(new String(result)), indexOfSmallest, indexOfBigger};
    }

    private long[] moveBigger(char[] digits, int indexOfBigger){
        int indexOfSmaller = indexOfBigger + 1;
        for(; indexOfSmaller < digits.length; indexOfSmaller++){
            if(digits[indexOfSmaller] > digits[indexOfBigger]){
                 break;
            }
        }
        indexOfSmaller = indexOfSmaller - 1;

        char[] result = new char[digits.length];
        int index = 0;
        for(; index < indexOfBigger; index++ ){
            result[index] = digits[index];
        }
        for(; index < indexOfSmaller; index++ ){
            result[index] = digits[index + 1];
        }
        result[index] = digits[indexOfBigger];
        index++;
        for(; index < digits.length; index++ ){
            result[index] = digits[index];
        }

        return new long[] {Long.parseLong(new String(result)), indexOfBigger, indexOfSmaller};

    }

    public long[] smallest(long n) {
        char[] digits = Long.toString(n).toCharArray();
        int indexOfSmallest = findLastSmallestDigit(digits);
        int indexOfBigger = findLeftestBiggerDigit(digits, indexOfSmallest);

//        if there is no numbers bigger than the smallest, then the number cannot be changed
        if(indexOfBigger == -1){
            return new long[]{n, -1, -1};
        }

        char smallest = digits[indexOfSmallest];
//        choose what digit is moved
//        (digits[indexOfBigger+1]!= smallest): to prevent errors in cases of numbers like "211131"
        if(smallest < digits[indexOfSmallest - 1] && digits[indexOfBigger+1]!= smallest){
            return movefSmallest(digits, indexOfSmallest, indexOfBigger);
        } else {
            return moveBigger(digits, indexOfBigger);
        }
    }
    
}

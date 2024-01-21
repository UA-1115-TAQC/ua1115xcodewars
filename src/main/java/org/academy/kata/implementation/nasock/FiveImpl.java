package org.academy.kata.implementation.nasock;

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
        return null;
    }

    public double solve(double m) {
        return 0;
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
    
    public int artificialRain(int[] v) {
        return 0;
    }
}

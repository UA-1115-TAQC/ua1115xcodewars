package org.academy.kata.implementation.nasock;

import org.academy.kata.Six;

public class SixImpl implements Six {
    private boolean isReal(double num){
        double decimalPart = (num - (int)num);
        return Double.valueOf(0L).equals(decimalPart);
    }

    public long findNb(long m) {
        double sqrt = Math.sqrt(m);
        if(!isReal(sqrt)) {
            return -1L;
        }

        double sqrtDeterminant = Math.sqrt(8 * sqrt + 1);
        if(!isReal(sqrtDeterminant)){
            return -1L;
        }
        return (long) (sqrtDeterminant - 1)/2;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return 0;
    }

    public double mean(String town, String strng) {
        return 0;
    }

    public double variance(String town, String strng) {
        return 0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
    
}

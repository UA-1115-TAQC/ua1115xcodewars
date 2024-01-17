package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        int i = 1;
        while (m > 0) {
            m -= (long) Math.pow(i, 3);
            i++;
        }
        if (m == 0) {
            return i-1;
        }
        return -1;
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

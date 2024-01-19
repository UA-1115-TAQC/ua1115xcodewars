package org.academy.kata.implementation.alevtyna30;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        long volume = 0;
        int n = 1;

        while (volume < m) {
            volume += (long) Math.pow(n, 3);
            if (volume == m) {
                return n;
            }
            n++;
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

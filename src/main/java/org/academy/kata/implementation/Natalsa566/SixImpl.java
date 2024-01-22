package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Six;

public class SixImpl implements Six {

    public long findNb(long m) {
        long n = (long) Math.sqrt(2 * Math.sqrt(m));
        if (n * (n + 1) / 2 * n * (n + 1) / 2 == m) {
            return n;
        } else {
            return -1;
        }
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

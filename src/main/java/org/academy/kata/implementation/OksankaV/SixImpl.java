package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        long n = 0;
        while (m > 0) {
            n++;
            m -= n * n * n;
        }
        return (m == 0) ? n : -1;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
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

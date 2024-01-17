package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        long n = 1;
        long sum = 0;
        while (sum < m) {
            sum += (long) Math.pow(n, 3);
            n++;
        }
        return sum == m ? n - 1 : -1;
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

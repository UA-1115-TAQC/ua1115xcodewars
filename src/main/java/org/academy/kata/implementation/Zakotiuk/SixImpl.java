package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        long cube_counter = 1;
        long total = 0;

        while (total < m){
            total += cube_counter * cube_counter * cube_counter;
            cube_counter++;
        }

        if(total == m)
            return cube_counter-1;
        else
            return -1;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        double numerator = x;
        double denominator = Math.sqrt(1 + x) + 1;

        return numerator / denominator;
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

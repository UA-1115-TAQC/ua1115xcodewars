package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        if(m > 0){
            long volume = 0;
            long cubes = 1;
            while(volume < m){
                volume += (long) Math.pow((cubes),3);
                cubes++;
            }
            return (volume==m) ? (cubes - 1) : -1;
        }
        throw new IllegalArgumentException();
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        if(x >= -1){
            return x / (Math.sqrt(1 + x) + 1.0);
        }
        throw new IllegalArgumentException();
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

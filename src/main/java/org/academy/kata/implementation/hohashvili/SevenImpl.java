package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Seven;

import java.util.Arrays;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double sum = Arrays.stream(arr).sum();
        double initLength = arr.length;
        double result = navg*(initLength+1)-sum;
        if (result <= 0) {
            throw new IllegalArgumentException("Invalid 'navg' parameter - too small");
        }
        return (long) result;
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

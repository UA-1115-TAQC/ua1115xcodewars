package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Seven;

import java.util.Arrays;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double sum = Arrays.stream(arr).sum();
        if (sum < navg) {
            throw new IllegalArgumentException();
        }
        return (long) Math.ceil((navg * (arr.length + 1)) - sum);
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

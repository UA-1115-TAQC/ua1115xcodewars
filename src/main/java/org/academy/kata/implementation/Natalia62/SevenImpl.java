package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double sum_arr = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum_arr += arr[i];
        }
        double dons = navg * (arr.length + 1) - sum_arr;
        if (dons > 0) {
            return (int) Math.ceil(dons);
        }
        else throw new IllegalArgumentException();
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

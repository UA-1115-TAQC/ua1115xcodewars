package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }
        double needSum = navg * (arr.length + 1);

        if (needSum <= sum) {
            throw new IllegalArgumentException();
        }

        long resulted_number = (long) Math.ceil(needSum - sum);
        return resulted_number;
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

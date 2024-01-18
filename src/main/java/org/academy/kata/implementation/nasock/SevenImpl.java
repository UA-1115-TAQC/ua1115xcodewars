package org.academy.kata.implementation.nasock;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        if (arr == null || navg < 0) {
            return -1L;
        }
        long sum = 0L;
        for (double num : arr) {
            sum = sum + (long) num;
        }
        if (arr.length > 0 && (sum / arr.length > navg)){
            return -1L;
        }
        long result = (long) (navg * (arr.length+1) - sum);
        return result;
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }

}

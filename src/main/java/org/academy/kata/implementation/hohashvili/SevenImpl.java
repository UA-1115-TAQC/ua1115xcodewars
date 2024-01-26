package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Seven;

import java.util.Arrays;
import java.util.Locale;

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
        double denominator = 1;
        double sum = 0.0;
        for(int i = 0; i < n; i++) {
            sum += 1/denominator;
            denominator += 3;
        }
        return String.format(Locale.US,"%.2f", sum);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

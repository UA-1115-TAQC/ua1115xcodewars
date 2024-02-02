package org.academy.kata.implementation.ystankevych;

import org.academy.kata.Seven;

import java.util.Arrays;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double result = navg * (arr.length + 1) - Arrays.stream(arr)
                .sum();
        if (result < 0) {
            throw new IllegalArgumentException();
        }
        return (long) Math.ceil(result);
    }

    public String seriesSum(int n) {
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += 1.0 / (1 + 3 * i);
        return String.format("%.2f", sum);
    }
}

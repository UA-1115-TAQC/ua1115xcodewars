package org.academy.kata.implementation.KhrystynaPavlikovska;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double currentSum = 0;

        for (double donation : arr) {
            currentSum += donation;
        }

        double targetSum = navg * (arr.length + 1);
        double requiredDonation = Math.ceil(targetSum - currentSum);

        if (requiredDonation <= 0) {
            throw new IllegalArgumentException("Invalid donation amount");
        }

        return (long) requiredDonation;
    }

    public String seriesSum(int n) {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + i * 3);
        }

        String result = String.format("%.2f", sum);

        return result;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

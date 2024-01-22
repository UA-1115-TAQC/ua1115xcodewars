package org.academy.kata.implementation.alevtyna30;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double currentTotal = 0;
        for (double donation : arr) {
            currentTotal += donation;
        }
        long nextDonation = (long) Math.ceil(navg * (arr.length + 1) - currentTotal);

        if (nextDonation <= 0) {
            throw new IllegalArgumentException("Last donation should be a positive number.");
        }

        return nextDonation;
    }

    public String seriesSum(int n) {
        if (n == 0) {
            return "0.00";
        }
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + i * 3);
        }
        sum = Math.round(sum * 100.0) / 100.0;

        return String.format("%.2f", sum);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

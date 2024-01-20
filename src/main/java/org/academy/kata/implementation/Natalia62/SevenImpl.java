package org.academy.kata.implementation.Natalia62;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    public String seriesSum(int n) {
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += 1.0 / (i * 3 + 1);
        }
        return String.format("%.2f", result);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

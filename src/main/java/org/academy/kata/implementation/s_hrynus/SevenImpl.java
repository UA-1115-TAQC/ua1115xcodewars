package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    public String seriesSum(int n) {
        if (n == 0) {
            return "0.00";
        }
        double sum = 0.0;
        double denominator = 1.0;
        for (int i = 0; i < n; i++) {
            sum += 1 / denominator;
            denominator += 3.0;
        }
        return String.format("%.2f", sum);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

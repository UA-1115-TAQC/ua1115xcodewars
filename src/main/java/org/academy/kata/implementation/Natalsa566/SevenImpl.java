package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    public String seriesSum(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + i * 3);
        }
        return String.format("%.2f", sum);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

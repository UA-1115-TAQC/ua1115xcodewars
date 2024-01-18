package org.academy.kata.implementation.nasock;

import org.academy.kata.Seven;


public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    public String seriesSum(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++){
            double denom = (i-1) * 2 + i;
            double num = 1/denom;
            sum = sum + num;
        }
        return String.format("%.2f", sum);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }

}

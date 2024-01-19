package org.academy.kata.implementation.nasock;

import org.academy.kata.Seven;


public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    public String seriesSum(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++){
            double num = 1.0/(3 * i - 2);
            sum = sum + num;
        }
        return String.format("%.2f", sum);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }

}

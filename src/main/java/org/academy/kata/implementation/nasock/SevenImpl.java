package org.academy.kata.implementation.nasock;

import org.academy.kata.Base;
import org.academy.kata.Seven;


public class SevenImpl extends Base implements Seven {
    public long newAvg(double[] arr, double navg) {
        if (arr == null || navg < 0) {
            throw new IllegalArgumentException ();
        }
        long sum = 0L;
        for (double num : arr) {
            sum = sum + (long) num;
        }
        if (arr.length > 0 && (sum / arr.length > navg)){
            throw new IllegalArgumentException ();
        }
        return (long) (navg * (arr.length + 1) - sum);
    }

    public String seriesSum(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++){
            double num = 1.0/(3 * i - 2);
            sum = sum + num;
        }
        return String.format("%.2f", sum);
    }

}

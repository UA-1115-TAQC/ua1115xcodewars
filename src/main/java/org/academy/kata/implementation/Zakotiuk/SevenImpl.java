package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Seven;

import java.text.DecimalFormat;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }
        double needSum = navg * (arr.length + 1);

        if (needSum <= sum) {
            throw new IllegalArgumentException();
        }

        long resulted_number = (long) Math.ceil(needSum - sum);
        return resulted_number;
    }

    public String seriesSum(int n) {

        if(n == 0)
            return "0.00";
        double counter = 4;
        double result = 1;
        for (int i = 0; i < n-1; i++) {
            result += 1/counter;
            counter+=3;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(result);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

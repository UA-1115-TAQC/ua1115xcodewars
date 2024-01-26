package org.academy.kata.implementation.Oleghon;

import org.academy.kata.Seven;

import java.util.stream.DoubleStream;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg){
    double result = navg * (arr.length + 1) - DoubleStream.of(arr).sum();
        if (result <= 0) throw new IllegalArgumentException();
        return (long) Math.ceil(result);
    }

    public String seriesSum(int n) {
        double dn = 0;
        int step = 1;

        for (int i = 1; i <= n; i++) {
            dn = dn + ((double) 1 / step);
            step += 3;
        }
        return String.format("%.2f", dn);
    }


    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

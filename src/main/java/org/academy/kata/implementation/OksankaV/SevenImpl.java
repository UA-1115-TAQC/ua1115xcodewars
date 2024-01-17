package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Seven;
import java.util.Arrays;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double sumArr = Arrays.stream(arr).sum();
        double result = navg * (arr.length + 1) - sumArr;
        if (result <= 0) throw new IllegalArgumentException();
        return (long) Math.ceil(result);
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

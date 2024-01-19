package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    public String seriesSum(int n) {
        double result = 1.00;
        double divider = 1.00;
        if(n != 0){
            for(int i = 1; i < n; i++){
                divider += 3;
                result += 1 / divider;
            }
        }
        return n == 0 ? "0.00" : String.format("%.2f", result);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

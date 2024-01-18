package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    public String seriesSum(int n) {
        if(n == 0){
            return "0.00";
        } else{
            double result = 1.00;
            double divider = 1.00;
            for(int i = 1; i < n; i++){
                divider += 3;
                result += 1 / divider;
            }

            String resultString = String.format("%.2f", result);
            return resultString;
        }
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Seven;
import java.lang.Math;
public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {

        if(arr != null && navg > 0){
            double sum = 0;
            int counter = 0;
            for (double v : arr) {
                sum += v;
                counter += 1;
            }
            int result = (int) Math.ceil(navg*(counter+1)-sum);
            if (result > 0){
                return result;
            }
        }
            throw new IllegalArgumentException();
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

}

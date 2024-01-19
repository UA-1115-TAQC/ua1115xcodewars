package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Seven;
import java.lang.Math;
public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {

        if(arr != null && navg > 0){
            double sum = 0;
            int counter = 0;
            for(int i = 0; i < arr.length; i++){
                sum += arr[i];
                counter +=1;
            }
            int result = (int) Math.ceil(navg*(counter+1)-sum);
            if (result >0){
                return result;
            } else{
                throw new IllegalArgumentException();
            }
        } else{
            throw new IllegalArgumentException();
        }
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

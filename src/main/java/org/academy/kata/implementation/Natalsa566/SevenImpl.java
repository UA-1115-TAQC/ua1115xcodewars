package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Seven;
import java.lang.IllegalArgumentException;
import java.lang.Math;
public class SevenImpl implements Seven {
    public long newAvg(double[] arr, double navg) {
        double currentSum = 0;
        for (double donation : arr) {
            currentSum += donation;
        }
             double currentAvg = currentSum / arr.length;
                 if (navg <= currentAvg) {
                    throw new IllegalArgumentException("The target average should be greater than the current average.");
                 }
                     long requiredDonation = (long) Math.ceil((navg * (arr.length + 1)) - currentSum);
                           if (requiredDonation <= 0) {
                               throw new IllegalArgumentException("The required donation should be a positive value.");
        }
                                 return requiredDonation;
    }

    public String seriesSum(int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + i * 3);
        }
        return String.format("%.2f", sum);
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

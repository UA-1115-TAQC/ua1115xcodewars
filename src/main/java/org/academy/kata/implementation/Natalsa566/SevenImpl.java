package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Seven;
import java.lang.IllegalArgumentException;
import java.lang.Math;
public class SevenImpl implements Seven {
    @Override
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
    public static void main(String[] args) {
        SevenImpl sevenImpl = new SevenImpl();
        double[] donations = {14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0};
        double targetAvg = 90.0;
            try {
                long result = sevenImpl.newAvg(donations, targetAvg);
                System.out.println("Required Donation: " + result);
                 } catch (IllegalArgumentException e) {
                     System.out.println("Error: " + e.getMessage());
        }
    }

    public String seriesSum(int n) {
        return null;
    }

    public int whereIsHe(int p, int bef, int aft) {
        return 0;
    }
}

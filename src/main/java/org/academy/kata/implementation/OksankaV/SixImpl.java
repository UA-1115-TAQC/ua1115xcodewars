package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class SixImpl implements Six {
    public long findNb(long m) {
        long n = 0;
        while (m > 0) {
            n++;
            m -= n * n * n;
        }
        return (m == 0) ? n : -1;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return 0;
    }

    public double[] getTempArray(String town, String strng) {
        int indexStart = strng.indexOf(town + ":");
        if (indexStart < 0) return new double[0];
        int indexEnd = strng.indexOf("\n", indexStart);
        String townStr = (indexEnd < 0) ? strng.substring(indexStart) : strng.substring(indexStart, indexEnd);
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(townStr);
        double[] tempArr = new double[12];
        int index = 0;
        while (matcher.find()) {
            tempArr[index++] = Double.parseDouble(matcher.group());
        }
        if (index == 0) return new double[0];
        return tempArr;
    }

    public double mean(String town, String strng) {
        double[] tempArr = getTempArray(town, strng);
        if (tempArr.length == 0) return -1.0;
        return Arrays.stream(tempArr).average().orElse(Double.NaN);
    }

    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        double[] tempArr = getTempArray(town, strng);
        if (tempArr.length == 0) return -1.0;
        double sumSqr = 0;
        for (double temp : tempArr) {
            sumSqr += (temp - mean) * (temp - mean);
        }
        return sumSqr / tempArr.length;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}

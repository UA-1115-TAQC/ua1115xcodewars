package org.academy.kata.implementation.OksankaV;

import org.academy.kata.Six;

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

    public double mean(String town, String strng) {
        return 0;
    }

    public double variance(String town, String strng) {
        return 0;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        String resultStr = "";
        boolean noValues = true;
        for (int i = 0; i < lstOf1stLetter.length; i++){
            int count = 0;
            for (String value : lstOfArt){
                if (value.startsWith(lstOf1stLetter[i])) {
                    String[] valArr = value.split(" ");
                    count += Integer.parseInt(valArr[1]);
                    noValues = false;
                }
            }
            resultStr += "(" + lstOf1stLetter[i] + " : " + count +")";
            if (i < lstOf1stLetter.length - 1) {
                resultStr += " - ";
            }
        }
        if (noValues) return "";
        return resultStr;
    }
}

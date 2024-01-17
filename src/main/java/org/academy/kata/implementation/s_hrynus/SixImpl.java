package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
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
        if (lstOf1stLetter.length == 0 || lstOfArt.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            int sum = 0;
            for (String arts : lstOfArt) {
                String[] values = arts.split(" ");
                if (lstOf1stLetter[i].equals(String.valueOf(values[0].charAt(0)))) {
                    sum += Integer.parseInt(values[1]);
                }
            }
            stringBuilder.append("(")
                    .append(lstOf1stLetter[i])
                    .append(" : ")
                    .append(sum)
                    .append(")")
                    .append(" - ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 3);
    }
}

package org.academy.kata.implementation.Julyuk;

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
        if (lstOfArt != null && lstOf1stLetter != null && lstOfArt.length > 0 && lstOf1stLetter.length > 0) {
            int[] count = new int[lstOf1stLetter.length];

            for (int i = 0; i < lstOfArt.length; i++) {
                String[] parts = lstOfArt[i].split(" ");
                if (parts.length == 2) {
                    String code = parts[0];
                    int quantity = Integer.parseInt(parts[1]);

                    for (int j = 0; j < lstOf1stLetter.length; j++) {
                        if (code.startsWith(lstOf1stLetter[j])) {
                            count[j] += quantity;
                        }
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < lstOf1stLetter.length; j++) {
                result.append("(").append(lstOf1stLetter[j]).append(" : ").append(count[j]).append(")");
                if (j != lstOf1stLetter.length - 1) {
                    result.append(" - ");
                }
            }

            return result.toString();
        }

        return "";
    }
}

package org.academy.kata.implementation.nasock;

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

    private String getTownString(String town, String strng){
        String[] strs = strng.split("\n");
        for(String str : strs){
            if(str.contains(town+":")){
                return str;
            }
        }
        return null;
    }

    private double[] getDoubles(String townStr){
        double[] doubles = new double[12];
        int i = 0;
        int endIndex = townStr.length()-1;
        while(endIndex >= 0){
            if(Character.isDigit(townStr.charAt(endIndex))){
                int startIndex = townStr.lastIndexOf(" ", endIndex) + 1;
                String doubleStr = townStr.substring(startIndex, endIndex + 1);
                doubles[i] = Double.parseDouble(doubleStr);
                i++;
                endIndex = townStr.lastIndexOf(",", endIndex) + 1;
            } else {
                endIndex--;
            }
        }
        return doubles;
    }

    private double[] getRainsByMonth(String town, String strng){
        String townStr = getTownString(town, strng);
        if (townStr == null){
            return null;
        }
        return getDoubles(townStr);
    }

    private double calculateMean(double[] rains){
        double sum = 0.0;
        for(double d : rains){
            sum += d;
        }
        return sum / 12;
    }

    public double mean(String town, String strng) {
        double[] rains = getRainsByMonth(town, strng);
        if(rains == null){
            return -1.0;
        }
        return calculateMean(rains);
    }

    public double variance(String town, String strng) {
        double[] rains = getRainsByMonth(town, strng);
        if(rains == null){
            return -1.0;
        }
        double mean = calculateMean(rains);
        double sum = 0.0;
        for(double d : rains){
            sum += Math.pow((d - mean), 2);
        }
        return sum / 12;
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
    
}

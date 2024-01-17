package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public static boolean isNumeric(String str) {
        try {
            // Attempt to parse the string as an integer
            Integer.parseInt(str);
            return true; // If successful, the string is numeric
        } catch (NumberFormatException e) {
            return false; // If an exception occurs, the string is not numeric
        }
    }
    public String nbaCup(String resultSheet, String toFind) {
        boolean play = false;
        int wins = 0;
        int draws = 0;
        int losses = 0;
        int scored = 0;
        int conceded = 0;
        int points = 0;
        List<String> splitSheet = new ArrayList<String>(Arrays.asList(resultSheet.split(",")));

        for(int i = 0; i < splitSheet.size(); i ++) {
            if (splitSheet.get(i).contains(toFind + ' ')) {
                play = true;
                String[] splitValue = splitSheet.get(i).replace(toFind+' ', "").trim().split(" ");

                int teamScore;
                int oppScore;
                if (isNumeric(splitValue[0])) {
                    // first team == toFind
                     teamScore = Integer.parseInt(splitValue[0]);
                     oppScore = Integer.parseInt(splitValue[splitValue.length - 1]);
                } else {
                    // second team == toFind
                    teamScore = Integer.parseInt(splitValue[splitValue.length - 1]);
                    oppScore = Integer.parseInt(splitValue[splitValue.length - 2]);
                }
                if (teamScore > oppScore) {
                    wins += 1;
                    scored += teamScore;
                    points += 3;
                } else if (teamScore == oppScore) {
                    draws += 1;
                    points += 1;
                } else {
                    losses += 1;
                    conceded += oppScore;
                }

            }
        }

        String result = toFind + ":W=" + wins +";D=" +draws+";L="+ losses+";Scored="+scored+";Conceded="+conceded+";Points=" + points+"\n";
        if (!play) {
            return toFind + ":This team didn't play!";
        }

        return result;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}

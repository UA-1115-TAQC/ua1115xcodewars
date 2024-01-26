package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;


public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
        String[] origSplit = book.split("\\n+");
        String result = "";
        int counter = 0;
        double origBalance = 0;
        double totalExpense = 0;
        for(String line:origSplit) {
            if (counter == 0) {
                origBalance = Double.parseDouble(line);
                result += "Original_Balance:_" + line + "\n";
            } else {
                String[] itemSplit = line.split(" ");
                List<String> newItem = new ArrayList<>(Arrays.asList(itemSplit));
                newItem.add(2, "Balance");
                totalExpense += Double.parseDouble(newItem.get(3));
                newItem.set(3, String.valueOf(origBalance-totalExpense));

                String newItemString = String.join("_", newItem) + '\n';
                result += newItemString;
            }
            counter++;
        }
        result += "Total_expense__" + String.format(Locale.US,"%.2f",totalExpense) + '\n';
        result += "Average_expense__" + String.format(Locale.US,"%.2f",totalExpense/(counter-1)) + '\n';
        return result;
    }

    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
    }

    public static Double[] findTown(String town, String strng) {
        String[] splitData = strng.split("\n");
        String[] monthData = {}; // month-value pairs
        for(String line :splitData) {
            String newLine = "";
            if (line.contains(town)) {
                newLine = line.substring(town.length()+1, line.length()-1);
                monthData = newLine.split(",");
                break;
            }
        }
        if (monthData.length == 0) {
            return null;
        }
        Double[] resultValues = new Double[12];
        int counter = 0;
        for (String val : monthData) {
            resultValues[counter] = Double.parseDouble(val.split(" ")[1]);
            counter++;
        }
        return resultValues;
    }

    public double mean(String town, String strng) {
        Double[] metrics = findTown(town, strng);
        Double sum = 0.0;

        if (metrics!= null) {
            for (Double d:metrics) {
                sum += d;
            }
            return sum/metrics.length;
        }
        return -1.0;
    }

    public double variance(String town, String strng) {
        Double[] metrics = findTown(town, strng);
        Double mean = this.mean(town, strng);
        if (metrics!= null) {
            double sumSquaredDiff = 0.0;
            for (double value : metrics) {
                double diff = value - mean;
                sumSquaredDiff += diff * diff;
            }
            return sumSquaredDiff / metrics.length;
        }
        return -1.0;
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
        if (toFind.equals("") ) {
            return "";
        }
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
        Map<String, Integer> result = new HashMap<>();
        for(String val: lstOf1stLetter) {
            result.put(val, 0 );
            for (String stock: lstOfArt) {

                if (String.valueOf(stock.charAt(0)).equals(val)) {
                    String[] splitStock = stock.split(" ");
                    int stockValue = Integer.parseInt(splitStock[1]);
                    result.put(val, result.get(val) + stockValue );
                }
            }
        }

        String formattedResult = "";
        // Format
        for (String key: result.keySet()) {
            String val = "(" + key + " : " + result.get(key) + ") - ";
            formattedResult += val;
        }

        return formattedResult.substring(0,formattedResult.length()-3);
    }
}

package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    public String balance(String book) {
        String[] lines = book.split("\n");
        String originalBalance = getPrice(lines[0]);
        double totalExpense = 0;
        double balanceAfterBuyingItem = Double.parseDouble(originalBalance);
        StringBuilder reportBuilder = new StringBuilder("Original Balance: " + originalBalance);

        for (int i = 1; i < lines.length; i++) {
            String[] items = getItemsWithoutNomenclatureNumber(lines[i]);
            double balanceForItem = Double.parseDouble(getPrice(items[0]));
            totalExpense += balanceForItem;
            balanceAfterBuyingItem -= balanceForItem;
            String nomenclatureNumber = lines[i].substring(0,4).trim();
            reportBuilder.append("\\r\\n")
                    .append(nomenclatureNumber + " " + items[1])
                    .append(" " + String.format("%.2f", balanceForItem))
                    .append(" Balance " + String.format("%.2f", balanceAfterBuyingItem));
        }

        double avgExpenses = totalExpense / (lines.length - 1);
        reportBuilder.append("\\r\\n").append("Total expense  " + String.format("%.2f", totalExpense))
                .append("\\r\\n").append("Average expense  " + String.format("%.2f", avgExpenses));
        return reportBuilder.toString();
    }

    private static String[] getItemsWithoutNomenclatureNumber(String line) {
        String itemWithoutNomenclatureNumber = line.replaceAll("\\s\\d{3}\\s", "");
        String nameOfItem = itemWithoutNomenclatureNumber.replaceAll("[^a-zA-Z]", "");
        return new String[]{itemWithoutNomenclatureNumber, nameOfItem};
    }

    private static String getPrice(String item) {
        Pattern pattern = Pattern.compile(".*\\b(\\d+\\.\\d+)\\b.*");
        Matcher matcher = pattern.matcher(item);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("Price for item " + item + " is absent!");
        }
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
        return null;
    }
}

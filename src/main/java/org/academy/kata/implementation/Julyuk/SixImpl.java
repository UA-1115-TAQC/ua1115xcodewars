package org.academy.kata.implementation.Julyuk;
import java.text.DecimalFormat;
import org.academy.kata.Six;

public class SixImpl implements Six {
    public long findNb(long m) {
        if(m > 0){
            long volume = 0;
            long cubes = 1;
            while(volume < m){
                volume += (long) Math.pow((cubes),3);
                cubes++;
            }
            return (volume==m) ? (cubes - 1) : -1;
        }
        throw new IllegalArgumentException();
    }

    public  String balance(String book) {
        if (book != null && !book.isEmpty()) {
            DecimalFormat df = new DecimalFormat("0.00");
            String[] lines = book.split("\n");
            double originalBalance = getOriginalBalance(lines);
            double currentBalance = originalBalance;
            double totalExpense = 0.0;

            StringBuilder result = new StringBuilder("Original Balance: " + df.format(originalBalance) + "\\r\\n");

            for (int i = 1; i < lines.length; i++) {
                String line = lines[i].replaceAll("[^a-zA-Z0-9.\\s]", " ").trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    int checkNumber = Integer.parseInt(parts[0]);
                    String category = parts[1];
                    double checkAmount = Double.parseDouble(parts[2]);

                    currentBalance -= checkAmount;
                    totalExpense += checkAmount;

                    result.append(String.format("%03d", checkNumber)).append(" ").append(category)
                            .append(" ").append(df.format(checkAmount)).append(" Balance ").append(df.format(currentBalance)).append("\\r\\n");
                }
            }

            result.append("Total expense  ").append(df.format(totalExpense)).append("\\r\\n");

            double averageExpense = totalExpense / (lines.length - 1);
            result.append("Average expense  ").append(df.format(averageExpense));

            return result.toString();
        }

        throw new IllegalArgumentException();
    }

    private static double getOriginalBalance(String[] lines) {
        double originalBalance;
        // Check if the first line contains special characters - any characters that are not 0-9, a-z, A-Z, spaces, dots
        if (lines[0].matches(".*[^a-zA-Z0-9.\\s].*")) {
            // Remove non-numeric characters (that are not 0-9) if special characters are present
            originalBalance = Double.parseDouble(lines[0].replaceAll("[^0-9.]", "").trim());
        } else {
            // Keep the first line as it is if no special characters are present
            originalBalance = Double.parseDouble(lines[0]);
        }
        return originalBalance;
    }


    public double f(double x) {
        if(x >= -1){
            return x / (Math.sqrt(1 + x) + 1.0);
        }
        throw new IllegalArgumentException();
    }

    public double mean(String town, String strng) {
        if (!town.isEmpty() && !strng.isEmpty()) {
            double sum = 0;
            int count = 0;

            String[] monthData = monthsValues(town, strng);

            for (String monthDatum : monthData) {
                sum += Double.parseDouble(monthDatum);
                count++;
            }

            if (count > 0) {
                return sum / count;
            } else {
                return -1.0;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }

    public double variance(String town, String strng) {
        if (!town.isEmpty() && !strng.isEmpty()) {
            String[] monthData = monthsValues(town, strng);
            double mean = mean(town, strng);
            double countOfObserv = 0;
            double squaresSum = 0;

            for (String monthDatum : monthData) {
                if (!monthDatum.isEmpty()) {
                    squaresSum += Math.pow((Double.parseDouble(monthDatum) - mean),2);
                    countOfObserv++;
                }
            }

            if (countOfObserv - 1 > 0) {
                return squaresSum / (monthData.length);
            } else {
                return -1.0;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }

    private static String[] monthsValues(String town, String strng) {
        String[] townRecords = strng.split("\n");
        for (String townRecord : townRecords) {
            if (townRecord.startsWith(town + ":")) {
                String[] months = townRecord.split(":")[1].trim().split(",");
                String[] monthData = new String[months.length];

                for (int i = 0; i < months.length; i++) {
                    monthData[i] = months[i].trim().split("\\s+")[1];
                }

                return monthData;
            }
        }

        return new String[0];
    }

    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}

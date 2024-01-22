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

            for (String s : lstOfArt) {
                String[] parts = s.split(" ");
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

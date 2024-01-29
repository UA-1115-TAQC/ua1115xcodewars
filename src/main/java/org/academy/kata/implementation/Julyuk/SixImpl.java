package org.academy.kata.implementation.Julyuk;
import java.text.DecimalFormat;
import org.academy.kata.Six;
import java.util.Arrays;
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

    public  String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) return "";

        if (!resultSheet.isEmpty()) {
            if(!resultSheet.contains(toFind+" ")) return toFind+":This team didn't play!";
            String[] lines = resultSheet.split(",");

            int matchesWon = 0;
            int matchesInDraw = 0;
            int matchesLost = 0;
            int scoredPoints = 0;
            int concededPoints = 0;

            for (String line: lines) {

                if (line.contains(toFind)) {
                    String[] lineArray = line.replaceAll(toFind, "teamINeed").split(" ");
                    String pointsInString1;
                    String pointsInString2;
                    if(lineArray[0].equals("teamINeed")){
                        pointsInString1=lineArray[1];
                        pointsInString2=lineArray[lineArray.length-1];
                    }else{
                        pointsInString1=lineArray[lineArray.length-1];
                        pointsInString2=lineArray[lineArray.length-3];
                    }
                    int points1, points2;

                    try{
                        points1 = Integer.parseInt(pointsInString1);
                        points2 = Integer.parseInt(pointsInString2);
                    }
                    catch(Exception e){
                        return  "Error(float number):" +line;
                    }
                    if (points1 > points2) {
                        matchesWon++;
                    }
                    else if (points1 < points2) {
                        matchesLost++;
                    }
                    else {
                        matchesInDraw++;
                    }

                    scoredPoints += points1;
                    concededPoints += points2;
                }
            }

            return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                    toFind, matchesWon, matchesInDraw, matchesLost, scoredPoints, concededPoints,
                    ((matchesWon * 3) + matchesInDraw));
        }

        throw new IllegalArgumentException();
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

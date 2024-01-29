package org.academy.kata.implementation.Oleghon;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.regex.Matcher;

public class SixImpl implements Six {
    public long findNb(long m) {
        long result = 1, sum = 0;
        while (sum < m) {
            sum += (long) Math.pow(result, 3);
            result++;
        }
        return sum == m ? result - 1 : -1;
    }

    public String balance(String book) {
        EightImpl eight = new EightImpl();
        final var pattern = Pattern.compile("[0-9]{1,}(\\.[0-9]*)");
        String[] cleanedBook = book.replaceAll("=|:|;|!|\\?|,|\\{|\\}", "").split("\n| ");
        float total = 0.0f;
        int count = 0;

        float balance = Float.parseFloat(cleanedBook[0]);
        final var sb = new StringBuilder("Original Balance: " + cleanedBook[0] + "\n");

        for (int i = 1; i < cleanedBook.length; i++) {
            if (cleanedBook[i].isEmpty()) continue;
            if (pattern.matcher(cleanedBook[i]).find()) {
                float d = Float.parseFloat(cleanedBook[i]);
                sb.append(String.format("%.2f", d));
                balance -= d;
                total += d;
                count++;
                sb.append(" Balance ").append(String.format("%.2f", balance)).append("\\r\\n");
                continue;
            }
            sb.append(cleanedBook[i]).append(" ");
        }
        sb.append("Total expense  ")
                .append(String.format("%.2f", total))
                .append("\\r\\n")
                .append("Average expense  ")
                .append(String.format("%.2f", eight.TwoDecimalPlaces(total / count)));
        return sb.toString();
    }

    public double f(double x) {
        return x / (Math.sqrt(x + 1) + 1);
    }

    public double mean(String town, String data) {
        return data.lines()
                .map(line -> line.split(":"))
                .filter(line -> line[0].equals(town))
                .map(line -> line[1])
                .flatMap(line -> stream(line.split(",")))
                .map(arr -> arr.split(" ")[1])
                .mapToDouble(Double::parseDouble)
                .average()
                .orElse(-1);
    }

    public double variance(String town, String data) {
        final double mean = mean(town, data);
        return data.lines()
                .map(line -> line.split(":"))
                .filter(line -> line[0].equals(town))
                .map(line -> line[1])
                .flatMap(line -> stream(line.split(",")))
                .map(arr -> arr.split(" ")[1])
                .mapToDouble(Double::parseDouble)
                .map(v -> (mean - v) * (mean - v))
                .average()
                .orElse(-1);
    }

    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isBlank()) return toFind;

        var pattern = Pattern.compile(toFind + " \\d{2,3}");
        var matcher = pattern.matcher(resultSheet);
        if (!matcher.find()) {
            return toFind + ":This team didn't play!";
        }

        int win = 0, lose = 0, draw = 0, scored = 0, conceded = 0, points = 0;

        String[] array = Arrays.stream(resultSheet.split(","))
                .filter(pattern.asPredicate())
                .toArray(String[]::new);

        for (String line : array) {
            System.out.println(line);
            Matcher matcher1 = pattern.matcher(line);
            String goalTeam;
            if (matcher1.find())
                goalTeam = matcher1.group();
            else return " ";

            String competitorTeam = matcher1.replaceAll("").trim();

            try {
                int goalTeamScore = extractScore(goalTeam);
                int competitorScore = extractScore(competitorTeam);

                scored += goalTeamScore;
                conceded += competitorScore;

                if (goalTeamScore > competitorScore) {
                    win++;
                    points += 3;
                } else if (goalTeamScore < competitorScore) lose++;
                else {
                    draw++;
                    points += 1;
                }
            } catch (NumberFormatException e) {
                return "Error(float number):" + line;
            }
        }

        return new StringBuilder(toFind)
                .append(":W=").append(win)
                .append(";D=").append(draw)
                .append(";L=").append(lose)
                .append(";Scored=").append(scored)
                .append(";Conceded=").append(conceded)
                .append(";Points=").append(points)
                .toString();
    }

    private static int extractScore(String line) {
        var pattern = "\\w+ ([a-zA-Z0-9]{4,} )?([a-zA-Z0-9]{4,} )?";
        return Integer.parseInt(line.replaceFirst(pattern, ""));
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";

        StringBuilder stringBuilder = new StringBuilder("(");
        int i = 0;
        for (String letter : lstOf1stLetter) {
            int sum = Arrays.stream(lstOfArt)
                    .filter(art -> art.startsWith(letter))
                    .map(art -> art.replaceAll("\\w+ ", ""))
                    .mapToInt(Integer::parseInt)
                    .sum();
            stringBuilder.append(letter).append(" : ").append(sum).append(")");
            if (i < lstOf1stLetter.length) {
                stringBuilder.append(" - (");
                i++;
            }
        }

        return stringBuilder.toString();

    }
}

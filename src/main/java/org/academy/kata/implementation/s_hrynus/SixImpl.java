package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;  

public class SixImpl extends Base implements Six {
    public static final int SCORES = 0;
    public static final int CONCEDED = 1;
    public static final int WIN = 2;
    public static final int LOSE = 3;
    public static final int DRAW = 4;
    private static final String FLOAT_NUMBER_ISOLATOR = "\\b(\\d+\\.\\d+)\\b";
    private static final String LINE_SEPARATOR = "\n";

    public long findNb(long m) {
        long n = 1;
        long sum = 0;
        while (sum < m) {
            sum += (long) Math.pow(n, 3);
            n++;
        }
        return sum == m ? n - 1 : -1;
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
        return x / (Math.sqrt(1 + x) + 1);
    }

    public double mean(String town, String strng) {
        OptionalDouble sumOfRainfallData = Stream.of(strng.split(LINE_SEPARATOR))
                .filter(citiesData -> citiesData.startsWith(town + ":"))
                .mapToDouble(SixImpl::getRainfallDataByMonths)
                .findFirst();
        return sumOfRainfallData.isEmpty() ? -1.0 : sumOfRainfallData.getAsDouble() / 12;
    }

    public double variance(String town, String strng) {
        double averageOfRainfall = mean(town, strng);
        Pattern pattern = Pattern.compile(FLOAT_NUMBER_ISOLATOR);
        return Stream.of(strng.split(LINE_SEPARATOR))
                .filter(cityData -> cityData.startsWith(town + ":"))
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);
                    return matcher.results()
                            .mapToDouble(match -> Double.parseDouble(match.group(1)))
                            .toArray();
                })
                .flatMapToDouble(DoubleStream::of)
                .map(value -> Math.pow(value - averageOfRainfall, 2))
                .average().orElse(-1.0);
    }

    private static double getRainfallDataByMonths(String cityData) {
        String[] monthsData = cityData.split(",");
        Pattern pattern = Pattern.compile(FLOAT_NUMBER_ISOLATOR);
        double rainfallDataByMoths = 0;
        for (String monthData : monthsData) {
            Matcher matcher = pattern.matcher(monthData);
            if (matcher.find()) {
                rainfallDataByMoths += Double.parseDouble(matcher.group(1));
            }
        }
        return rainfallDataByMoths;
    }


    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.equals("")) {
            return "";
        }
        if (!resultSheet.contains(toFind + " ")) {
            return toFind + ":This team didn't play!";
        }
        String[] games = resultSheet.split(",");
        int[] statistic = new int[5];
        for (String game : games) {
            if (game.contains(toFind)) {
                List<Integer> gameScore = getGameScore(game);
                String team = extractTeams(game);
                if (isFloatingNumberPresent(game)) {
                    return "Error(float number):" + game;
                }
                if ((team.startsWith(toFind) && gameScore.get(0) > gameScore.get(1))) {
                    statistic[SCORES] += gameScore.get(0);
                    statistic[CONCEDED] += gameScore.get(1);
                    statistic[WIN]++;
                }
                if (!team.startsWith(toFind) && gameScore.get(0) < gameScore.get(1)) {
                    statistic[SCORES] += gameScore.get(1);
                    statistic[CONCEDED] += gameScore.get(0);
                    statistic[WIN]++;
                }
                if (!team.startsWith(toFind) && gameScore.get(0) > gameScore.get(1)) {
                    statistic[SCORES] += gameScore.get(1);
                    statistic[CONCEDED] += gameScore.get(0);
                    statistic[LOSE]++;
                }
                if (team.startsWith(toFind) && gameScore.get(0) < gameScore.get(1)) {
                    statistic[SCORES] += gameScore.get(0);
                    statistic[CONCEDED] += gameScore.get(1);
                    statistic[LOSE]++;
                }
            }
        }
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, statistic[WIN], statistic[DRAW], statistic[LOSE], statistic[SCORES],
                statistic[CONCEDED], calculatePoints(statistic));
    }

    private static List<Integer> getGameScore(String game) {
        List<Integer> score = new ArrayList<>();
        Pattern decimalPattern = Pattern.compile("\\s(\\d+)\\s");
        Matcher decimalMatcher = decimalPattern.matcher(game + " ");
        if (decimalMatcher.find()) {
            score.add(Integer.parseInt(decimalMatcher.group().trim()));
        }
        if (decimalMatcher.find()) {
            score.add(Integer.parseInt(decimalMatcher.group().trim()));
        }
        return score;
    }

    private static boolean isFloatingNumberPresent(String game) {
        Pattern floatNumberPatter = Pattern.compile("\\s(\\d+\\.\\d+)\\s");
        Matcher floatNumberMatcher = floatNumberPatter.matcher(game + " ");
        return floatNumberMatcher.find();
    }

    private static String extractTeams(String game) {
        String result = game.replaceAll("\\d+", "");
        return result.replaceAll("\\s+", " ").trim();
    }

    private static int calculatePoints(int[] statistic) {
        return statistic[WIN] * 3 + statistic[DRAW];
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

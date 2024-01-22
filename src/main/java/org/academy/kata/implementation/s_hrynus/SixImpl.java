package org.academy.kata.implementation.s_hrynus;

import org.academy.kata.Six;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class SixImpl implements Six {





    private static final String FLOAT_NUMBER_ISOLATOR = "\\b(\\d+\\.\\d+)\\b";
    private static final String LINE_SEPARATOR = "\n";

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
        double sumOfRainfallData = Stream.of(strng.split(LINE_SEPARATOR))
                .filter(citiesData -> citiesData.startsWith(town + ":"))
                .mapToDouble(SixImpl::getRainfallDataByMonths)
                .sum();
        return sumOfRainfallData != 0 ? sumOfRainfallData / 12 : - 1.0;
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
        return null;
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}

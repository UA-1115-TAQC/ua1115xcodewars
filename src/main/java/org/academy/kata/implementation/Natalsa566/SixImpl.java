package org.academy.kata.implementation.Natalsa566;

import org.academy.kata.Six;
import java.util.regex.*;
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

    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }
        String[] matches = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;
        String teamPattern = "[a-zA-Z0-9]+(?:\\s[a-zA-Z0-9]+)*";
        String scorePattern = "\\d+(?:\\.\\d+)?";
        for (String match : matches) {
            Pattern pattern = Pattern.compile("(" + teamPattern + ")\\s(" + scorePattern + ")\\s(" + teamPattern + ")\\s(" + scorePattern + ")");
            Matcher matcher = pattern.matcher(match);

            if (matcher.matches()) {
                String team1 = matcher.group(1);
                String team2 = matcher.group(3);

                double score1 = Double.parseDouble(matcher.group(2));
                double score2 = Double.parseDouble(matcher.group(4));

                if (team1.equals(toFind) || team2.equals(toFind)) {
                    scored += (int) score1;
                    conceded += (int) score2;

                    if (score1 > score2) {
                        wins++;
                    } else if (score1 == score2) {
                        draws++;
                    } else {
                        losses++;
                    }
                }
            } else {
                return "Error(float number):" + match;
            }
        }

        if (wins + draws + losses == 0) {
            return toFind + ":This team didn't play!";
        }

        int points = wins * 3 + draws;
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
}

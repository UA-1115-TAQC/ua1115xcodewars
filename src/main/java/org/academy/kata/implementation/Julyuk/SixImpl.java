package org.academy.kata.implementation.Julyuk;

import org.academy.kata.Six;
import java.util.Arrays;
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
                    else if (points1 == points2) {
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
        return null;
    }
}

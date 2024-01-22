package org.academy.kata.implementation.nasock;

import org.academy.kata.Six;

public class SixImpl implements Six {
    private boolean isReal(double num){
        double decimalPart = (num - (int)num);
        return Double.valueOf(0L).equals(decimalPart);
    }

    public long findNb(long m) {
        double sqrt = Math.sqrt(m);
        if(!isReal(sqrt)) {
            return -1L;
        }

        double sqrtDeterminant = Math.sqrt(8 * sqrt + 1);
        if(!isReal(sqrtDeterminant)){
            return -1L;
        }
        return (long) (sqrtDeterminant - 1)/2;
    }

    public String balance(String book) {
        return null;
    }

    public double f(double x) {
        return 0;
    }

    private String getTownString(String town, String strng){
        String[] strs = strng.split("\n");
        for(String str : strs){
            if(str.contains(town+":")){
                return str;
            }
        }
        return null;
    }

    private double[] getDoubles(String townStr){
        double[] doubles = new double[12];
        int i = 0;
        int endIndex = townStr.length()-1;
        while(endIndex >= 0){
            if(Character.isDigit(townStr.charAt(endIndex))){
                int startIndex = townStr.lastIndexOf(" ", endIndex) + 1;
                String doubleStr = townStr.substring(startIndex, endIndex + 1);
                doubles[i] = Double.parseDouble(doubleStr);
                i++;
                endIndex = townStr.lastIndexOf(",", endIndex) + 1;
            } else {
                endIndex--;
            }
        }
        return doubles;
    }

    private double[] getRainsByMonth(String town, String strng){
        String townStr = getTownString(town, strng);
        if (townStr == null){
            return null;
        }
        return getDoubles(townStr);
    }

    private double calculateMean(double[] rains){
        double sum = 0.0;
        for(double d : rains){
            sum += d;
        }
        return sum / 12;
    }

    public double mean(String town, String strng) {
        double[] rains = getRainsByMonth(town, strng);
        if(rains == null){
            return -1.0;
        }
        return calculateMean(rains);
    }

    public double variance(String town, String strng) {
        double[] rains = getRainsByMonth(town, strng);
        if(rains == null){
            return -1.0;
        }
        double mean = calculateMean(rains);
        double sum = 0.0;
        for(double d : rains){
            sum += Math.pow((d - mean), 2);
        }
        return sum / 12;
    }

    private String getScoredStr(String resultSheet, int startIndex) {
        int endIndex = startIndex + 1;
        while(endIndex < resultSheet.length()){
            char ch = resultSheet.charAt(endIndex);
            if(!Character.isDigit(ch) && ch != '.'){
                break;
            }
            endIndex++;
        }
        return resultSheet.substring(startIndex, endIndex);
    }

    private String getConcededStr(String resultSheet, int endIndex) {
        int startIndex = endIndex - 1;
        while(startIndex >= 0){
            char ch = resultSheet.charAt(startIndex);
            if(!Character.isDigit(ch) && ch != '.'){
                break;
            }
            startIndex--;
        }
        return resultSheet.substring(startIndex + 1, endIndex);
    }

    private String makeErrorMsg(String resultSheet, int index){
        int startIndex = resultSheet.lastIndexOf(",", index) + 1 ;
        int endIndex = resultSheet.indexOf(",", index);
        return "Error(float number):" + resultSheet.substring(startIndex, endIndex);
    }

    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()){
            return "";
        }
        int teamIndex = resultSheet.indexOf(toFind);
        if (teamIndex == -1) {
            return toFind + ":This team didn't play!";
        }
//        check that the found name is not a part of other name
        int tempIndex = teamIndex + toFind.length();
        if(tempIndex >= resultSheet.length() || resultSheet.charAt(tempIndex) != ' '){
            return toFind + ":This team didn't play!";
        }
        int wins = 0;
        int draws = 0;
        int losses = 0;
        int scored = 0;
        int conceded = 0;
        while (teamIndex > -1) {
            //            get the start index of score of toFind team
            teamIndex = teamIndex + toFind.length() + 1;
            if(teamIndex >= resultSheet.length()){
                return "Error: result is missing";
            }
            String numStr = getScoredStr(resultSheet, teamIndex);
            //            check if number is float
            if (numStr.contains(".")){
                return makeErrorMsg( resultSheet, teamIndex);
            }
            int gameScored = Integer.parseInt(numStr);
            scored = scored + gameScored;

            //            get the end index of score of rival team
            int rivalIndex = teamIndex + numStr.length();
            if (rivalIndex >= resultSheet.length() || resultSheet.charAt(rivalIndex) == ','){
                //            the score of rival team is before toFind team
                rivalIndex = rivalIndex - numStr.length() - toFind.length() - 2;
            } else {
                //            the score of rival team is after toFind team
                rivalIndex = resultSheet.indexOf(",", rivalIndex) ;
                if (rivalIndex == -1){
                    rivalIndex = resultSheet.length();
                }
            }
            numStr = getConcededStr(resultSheet, rivalIndex);
            //            check if number is float
            if (numStr.contains(".")){
                return makeErrorMsg(resultSheet, teamIndex);
            }
            int gameConceded = Integer.parseInt(numStr) ;
            conceded = conceded + gameConceded;

            if(gameScored < gameConceded){
                losses++;
            } else if(gameScored > gameConceded){
                wins++;
            } else {
                draws++;
            }
            teamIndex = resultSheet.indexOf(toFind, teamIndex);

        }
        return toFind+":W=" + wins + ";D=" + draws + ";L=" + losses + ";Scored=" + scored
                + ";Conceded=" + conceded + ";Points=" + (wins * 3 + draws);
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return null;
    }
    
}

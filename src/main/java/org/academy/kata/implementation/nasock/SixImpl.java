package org.academy.kata.implementation.nasock;

import org.academy.kata.Base;
import org.academy.kata.Six;


import java.util.Arrays;


public class SixImpl extends Base implements Six {
    private boolean isInteger(double num){
        double decimalPart = num - (int)num;
        return Double.valueOf(0L).equals(decimalPart);
    }

    public long findNb(long m) {
        double sqrt = Math.sqrt(m);
        if(!isInteger(sqrt)) {
            return -1L;
        }

        double sqrtDeterminant = Math.sqrt(8 * sqrt + 1);
        if(!isInteger(sqrtDeterminant)){
            return -1L;
        }
        return (long) (sqrtDeterminant - 1)/2;
    }

    private int findStrStart(int index, char[] chars){
        for(int i = index; i< chars.length; i++){
            char ch = chars[i];
            if(Character.isAlphabetic(ch)){
                return i;
            }
        }
        return -1;
    }

    private int findNumStart(int index, char[] chars){
        for(int i = index; i< chars.length; i++){
            char ch = chars[i];
            if (Character.isDigit(ch)){
                return i;
            }
        }
        return -1;
    }

    private int findStrEnd(int index, char[] chars){
        for(int i = index; i < chars.length; i++){
            char ch = chars[i];
            if(!Character.isAlphabetic(ch) && ch != ' ' &&  ch != '.'){
                return i;
            }
        }
        return -1;
    }

    private int findNumEnd(int index, char[] chars){
        for(int i = index; i < chars.length; i++){
            char ch = chars[i];
            if (!Character.isDigit(ch) &&  ch != '.'){
                if (i > 0 && chars[i-1] == '.'){
                    return i - 1;
                }
                return i;
            }
        }
        return -1;
    }

    private String makeSubstring(int startIndex, int endIndex, char[] chars){
        char[] numChars = new char[endIndex - startIndex];
        int j = 0;
        for(int i = startIndex; i <endIndex; i++){
            numChars[j] = chars[i];
            j++;
        }
        return new String(numChars);
    }

    private void makeLineComponents(String line, String[] components){
        char[] chars = line.toCharArray();
        int startIndex = findNumStart(0, chars);
        if (startIndex == -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        int endtIndex = findNumEnd(startIndex, chars);
        if (endtIndex == -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        components[0] = makeSubstring(startIndex, endtIndex, chars);

        startIndex = findStrStart(endtIndex, chars);
        if (startIndex == -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        endtIndex = findStrEnd(startIndex, chars);
        if (endtIndex == -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        components[1] = makeSubstring(startIndex, endtIndex, chars);

        startIndex = findNumStart(endtIndex, chars);
        if (startIndex == -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        endtIndex = findNumEnd(startIndex, chars);
        if (endtIndex == -1){
            endtIndex = chars.length;
        }
        components[2] =  makeSubstring(startIndex, endtIndex, chars);

    }

    private double findBalance(String line){
        char[] chars = line.toCharArray();
        int startIndex = findNumStart(0, chars);
        if (startIndex == -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        int endtIndex = findNumEnd(startIndex, chars);
        if (endtIndex == -1){
            endtIndex = chars.length;
        }
        String numStr = makeSubstring(startIndex, endtIndex, chars);
        return Double.parseDouble(numStr);
    }

    public String balance(String book) {
        String[] strs = book.split("\n");

        String balanceStr = strs[0];
        double balance = findBalance(balanceStr);
        String resultStr = "Original Balance: " + String.format("%.2f",balance) + "\\r\\n";;

        double currentBalance = balance;
        int countExpences = 0;
        String[] components = new String[3];
        for (int i = 1; i < strs.length; i++){
            String currentLine = strs[i];
            if (currentLine.isEmpty()){
                continue;
            }
            makeLineComponents(currentLine, components);
            int num = Integer.parseInt(components[0]);
            resultStr = resultStr + num + " ";

            resultStr = resultStr + components[1].trim() + " ";

            double expense = Double.parseDouble(components[2]);
            resultStr = resultStr + String.format("%.2f", expense) + " ";

            currentBalance = currentBalance - expense;
            resultStr = resultStr + "Balance " + String.format("%.2f", currentBalance) + "\\r\\n";

            countExpences++;
        }

        double expense = balance - currentBalance;
        double avgExpense = 0.0;
        if(countExpences > 0 ) {
            avgExpense = expense / countExpences;
        }
        return resultStr + "Total expense  " + String.format("%.2f",expense) + "\\r\\n"
        + "Average expense  " + String.format("%.2f",avgExpense);
    }

    public double f(double x) {
        return x / (Math.sqrt(1.0 + x) + 1.0);
    }

    private String getTownString(String town, String strng){
        String[] strs = strng.split("\n");
        for(String str : strs){
            str = str.trim();
            if(str.startsWith(town+":")){
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

    private int getNum(String str){
        String numStr = "";
        for(int i = str.length() - 1; i >=0; i--){
            char digitCh = str.charAt(i);
            if(!Character.isDigit(digitCh)){
                break;
            }
            numStr = digitCh + numStr;
        }
        if(numStr.isEmpty()){
            return 0;
        }
        return Integer.parseInt(numStr);
    }

    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if(lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0 ){
            return "";
        }
        Arrays.sort(lstOfArt);
        String result = "";
        for(String letter : lstOf1stLetter) {
            int sum = 0;
            boolean wasAlreadyFaund = false;
            for(String book : lstOfArt){
                String firstLetter = book.substring(0, 1);
                if (firstLetter.equals(letter)) {
                    int quantity = getNum(book);
                    sum = sum + quantity;
                    wasAlreadyFaund = true;
                } else if (wasAlreadyFaund){
                    break;
                }
            }
            result = result + "(" + letter + " : " + sum + ") - ";
        }
        if(result.charAt(result.length() - 1 ) == ' '){
            return result.substring(0, result.length() - 3);
        }
        return result;
    }
    
}

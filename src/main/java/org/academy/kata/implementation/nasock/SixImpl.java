package org.academy.kata.implementation.nasock;

import org.academy.kata.Six;


public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
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
        return 0;
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
        return null;
    }

}

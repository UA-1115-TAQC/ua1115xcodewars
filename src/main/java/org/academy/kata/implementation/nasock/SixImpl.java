package org.academy.kata.implementation.nasock;

import org.academy.kata.Six;

import java.util.Arrays;

public class SixImpl implements Six {
    public long findNb(long m) {
        return 0;
    }

    private int findStart(int index, char[] chars, boolean lookForDigits){
        for(int i = index; i< chars.length; i++){
            char ch = chars[i];
            if (lookForDigits && Character.isDigit(ch)){
                return i;
            } else if(!lookForDigits && Character.isAlphabetic(ch)){
                return i;
            }
        }
        return -1;
    }

    private int findEnd(int index, char[] chars, boolean lookForDigits){
        for(int i = index; i < chars.length; i++){
            char ch = chars[i];
            if (lookForDigits && !Character.isDigit(ch) &&  ch != '.'){
                if (i > 0 && chars[i-1] == '.'){
                    return i - 1;
                }
                return i;
            } else if(!lookForDigits && !Character.isAlphabetic(ch) && ch != ' ' &&  ch != '.'){
                return i;
            }
        }
        return -1;
    }

    private String makeSubstring(int startIndex, int endtIndex, char[] chars){
        char[] numChars = new char[endtIndex - startIndex];
        int j = 0;
        for(int i = startIndex; i <endtIndex; i++){
            numChars[j] = chars[i];
            j++;
        }
        return new String(numChars);
    }

    private String[] makeLineComponents(String line, String[] components){
        char[] chars = line.toCharArray();
        boolean lookForDigits = true;
        int startIndex = findStart(0, chars, lookForDigits);
        if (startIndex == -1){
//            TODO exeption
        }
        int endtIndex = findEnd(startIndex, chars, lookForDigits);
        if (endtIndex == -1){
            //            TODO exeption
        }
        components[0] = makeSubstring(startIndex, endtIndex, chars);

        lookForDigits = false;
        startIndex = findStart(endtIndex, chars, lookForDigits);
        if (startIndex == -1){
            //            TODO exeption
        }
        endtIndex = findEnd(startIndex, chars, lookForDigits);
        if (endtIndex == -1){
            //            TODO exeption
        }
        components[1] = makeSubstring(startIndex, endtIndex, chars);

        lookForDigits = true;
        startIndex = findStart(endtIndex, chars, lookForDigits);
        if (startIndex == -1){
            //            TODO exeption
        }
        endtIndex = findEnd(startIndex, chars, lookForDigits);
        if (endtIndex == -1){
            endtIndex = chars.length;
        }
        components[2] =  makeSubstring(startIndex, endtIndex, chars);

        return components;
    }

    private double findBalance(String line){
        char[] chars = line.toCharArray();
        boolean lookForDigits = true;
        int startIndex = findStart(0, chars, lookForDigits);
        if (startIndex == -1){
            //            TODO exeption
        }
        int endtIndex = findEnd(startIndex, chars, lookForDigits);
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
            components = makeLineComponents(currentLine, components);
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

    public static void main(String[] args){
        SixImpl e = new SixImpl();
//		System.out.println(e.balance("1000.00!=\n125 Market !=:125.45\n126 Hardware =34.95" +
//                "\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10"));
//        System.out.println("***************");
        System.out.println(e.balance("1233.00\n125 Hardware;! 24.80?\n123 Flowers 93.50;\n127 " +
                "Meat 120.90\n120 Picture 34.00\n124 Gasoline 11.00\n" +
                "123 Photos;! 71.40?\n122 Picture 93.50\n132 Tyres;! 19.00,?;\n129 " +
                "Stamps; 13.60\n129 Fruits{} 17.60\n129 Market;! 128.00?\n121 Gasoline;! 13.60?"));


	}
}

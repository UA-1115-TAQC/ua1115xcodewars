package org.academy.kata.implementation.nasock;

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

    public String nbaCup(String resultSheet, String toFind) {
        return null;
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

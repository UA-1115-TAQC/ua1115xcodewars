package org.academy.kata.implementation.hohashvili;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    public int zeros(int n) {
        return 0;
    }

    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    public double solve(double m) {
        return 0;
    }

    public  long[] smallest(long n) {
        String nStr = Long.toString(n);
        int iDigit = 0;
        int smallestDigit = Integer.parseInt(String.valueOf(nStr.charAt(0)));
        for (int i = 1; i < nStr.length(); i++) {
            int newNum = Integer.parseInt(String.valueOf(nStr.charAt(i)));
            if (newNum < smallestDigit) {
                smallestDigit = newNum;
                iDigit = i;
            }
        }
        nStr = nStr.substring(0,iDigit) + nStr.substring(iDigit+1);
        if (smallestDigit == 0) {
            return new long[]{Long.parseLong(nStr), smallestDigit, 0};
        }
        System.out.println(nStr);

        long smallestNum = n;
        for (int i = 0; i < nStr.length(); i++) {

        }
        return null;
//        return new long[]{smallestNum, smallestI, smallestJ};
    }

    public static String swapDigits(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }


    public int artificialRain(int[] v) {
        return 0;
    }
}

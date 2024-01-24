package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;

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

    public long[] smallest(long n) {
        String strNumber = Long.toString(n);
        String[] numbers = strNumber.split("");
        ArrayList<Integer> numbersInt = new ArrayList<>();

        for (String element : numbers) {
            numbersInt.add(Integer.parseInt(element));
        }

        long minNumber = n;
        int fromIndex = 0;
        int toIndex = 0;

        for (int i = 0; i < numbersInt.size(); i++) {
            for (int j = 0; j < numbersInt.size(); j++) {
                if (i != j) {
                    ArrayList<Integer> copy = new ArrayList<>(numbersInt);
                    int digit = copy.remove(i);
                    copy.add(j, digit);
                    long newNumber = createNumber(copy);
                    if (newNumber < minNumber) {
                        minNumber = newNumber;
                        fromIndex = i;
                        toIndex = j;
                    }
                }
            }
        }

        return new long[]{minNumber, fromIndex, toIndex};
    }

    private long createNumber(ArrayList<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : numbers) {
            sb.append(num);
        }
        return Long.parseLong(sb.toString());
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

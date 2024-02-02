package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;

public class FiveImpl implements Five {
    public long[] gap(int g, long m, long n) {
        long result = 0;
        long first_number = 0;
        for(long i = m; i < n; ++i){
            if (isPrime(i)){
                result = i;
                if( result-first_number == g) {
                    return new long[]{result-g, result};
                }
                first_number = i;

            }
        }
        return null;
    }
    private boolean isPrime(long num) {
        if (num <= 1) {
            return false; // Число менше або дорівнює 1 не є простим
        }
        if (num <= 3) {
            return true; // 2 і 3 є простими числами
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false; // Парні числа (крім 2) не є простими
        }

        // Перевірка, чи число ділиться на будь-яке інше число від 5 до кореня з числа
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true; // Якщо не виявлено дільників, то число є простим
    }

    public int zeros(int n) {

        int counter = 0;
        while (n >= 5) {
            n = n/5;
            counter += n;
        }
        return counter;
    }

    public BigInteger perimeter(BigInteger n) {

        BigInteger future;
        BigInteger sum = BigInteger.ZERO;
        BigInteger counter = BigInteger.ZERO;
        BigInteger past_past = BigInteger.ONE;
        for(BigInteger i = BigInteger.ONE; i.compareTo(n.add(BigInteger.ONE)) <= 0; i = i.add(BigInteger.ONE)){
            future = counter.add(past_past);
            sum = sum.add(future);
            past_past = counter;
            counter = future;
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    public double solve(double m) {
        double left = 0;
        double right = 1, arv;
        double accuracy = 1e-12;
        while (right - left > accuracy) {
            arv = (left + right) / 2;
            double u = arv / Math.pow(1 - arv, 2);
            if (u > m) {
                right = arv;
            } else {
                left = arv;
            }
        }
        return (left + right) / 2;
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

    private static long createNumber(ArrayList<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : numbers) {
            sb.append(num);
        }
        return Long.parseLong(sb.toString());
    }

}

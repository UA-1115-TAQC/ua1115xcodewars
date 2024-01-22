package org.academy.kata.implementation.Zakotiuk;

import org.academy.kata.Five;

import java.math.BigInteger;

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
    public boolean isPrime(long num) {
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
        return 0;
    }

    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    public double solve(double m) {
        return 0;
    }

    public long[] smallest(long n) {
        return new long[0];
    }

    public int artificialRain(int[] v) {
        return 0;
    }
}

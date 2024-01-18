package org.academy.kata.implementation.nasock;

import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EightImpl implements Eight {
    public int liters(double time) {
        return 0;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    public float mpgToKPM(float mpg) {
        return 0;
    }

    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
    }

    public int stringToNumber(String str) {
        return 0;
    }

    public double TwoDecimalPlaces(double number) {
        return 0;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }

    private boolean isNatural(double n){
        if (n <= 0){
            return false;
        }
        double decimalPart = n - (int)n;
        return decimalPart == 0;
    }

    private boolean isNatural(BigDecimal n){
        BigDecimal zero = BigDecimal.valueOf(0);
        if (n.compareTo(zero) <= 0){
            return false;
        }
        BigDecimal scaled = n.setScale(0, RoundingMode.HALF_UP);
        BigDecimal result = n.subtract(scaled);
        return (result.compareTo(zero) == 0);
    }

    private boolean isPrime(double n){
        if(!isNatural(n) || n == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            double d = n / i;
            if (isNatural(d)) {
                return false;
            }
        }
        return true;
    }

    private BigDecimal factorial(double n){
        BigDecimal f = BigDecimal.valueOf(n);
        for(int i = 1; i < n; i++){
            f = f.multiply(BigDecimal.valueOf(n - i));
        }
        return f;
    }

    public boolean am_i_wilson(double n) {
        if(!isPrime(n)){
            return false;
        }
        double sqr = n*n;
        BigDecimal fct = factorial(n-1).add(BigDecimal.valueOf(1));
        BigDecimal div = fct.divide(BigDecimal.valueOf(sqr));
        return isNatural(div);
    }

}

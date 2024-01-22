package org.academy.kata.implementation.nasock;

import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EightImpl implements Eight {
    public int liters(double time) {
        if (time < 0) {
            throw new IllegalArgumentException();
        }
        return (int) time / 2;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }

        double volume  = length * width * height;
        BigDecimal bd = new BigDecimal(volume);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
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
        char[] chars = str.toCharArray();
        int num = 0;
        int i = 0;
        boolean isNegative = false;
        if (chars[0] == '-'){
            i = 1;
            isNegative = true;
        }
        for(; i < chars.length; i++){
            int currentNum = chars[i] - '0';
            num = num * 10 + currentNum;
        }
        if(isNegative){
            num = num * -1;
        }
        return num;
    }

    public double TwoDecimalPlaces(double number) {
        BigDecimal bd = BigDecimal.valueOf(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
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

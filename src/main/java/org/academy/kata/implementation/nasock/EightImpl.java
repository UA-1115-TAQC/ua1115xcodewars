package org.academy.kata.implementation.nasock;

import org.academy.kata.Base;
import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class EightImpl extends Base implements Eight {
    private static float GALON_TO_LITERS = 4.54609188F;
    private static float MILE_TO_KM = 1.609344F;

    public int liters(double time) {
        return (int) time / 2;
    }

    public double getVolumeOfCuboid(double length, double width, double height) {
        double volume  = length * width * height;
        BigDecimal bd = new BigDecimal(volume);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public float mpgToKPM(float mpg) {
        float kpl  = mpg * MILE_TO_KM / GALON_TO_LITERS;
        BigDecimal bd = BigDecimal.valueOf(kpl);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }

    private boolean hasSqRt(int num){
        int sqrt = (int) Math.sqrt(num);
        return sqrt*sqrt == num;
    }

    public int[] squareOrSquareRoot(int[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int num = array[i];
            if (hasSqRt(num)) {
                result[i] = (int) Math.sqrt(num);
            } else {
                result[i] = num*num;
            }
        }
        return result;
    }

    public int[] countPositivesSumNegatives(int[] input) {
        if(input == null || input.length == 0){
            return new int[]{};
        }

        int count = 0;
        int sum = 0;
        for(int num : input){
            if (num > 0){
                count++;
            } else if (num < 0){
                sum = sum + num;
            }
        }
        return new int[]{count, sum};
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

    private boolean isInteger(double num){
        double decimalPart = num - (int)num;
        return decimalPart == 0.0;
    }

    private int[] resizeArr(int[] arr, int newLength){
        int[] newArr = new int[newLength];
        for (int i = 0; i < newArr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public int[] divisibleBy(int[] numbers, int divider) {
        int[] result = new int[numbers.length];
        int j = 0;
        for(int num : numbers) {
            double div = num/(double)divider;
            if(isInteger(div)){
                result[j] = num;
                j++;
            }
        }
        return  resizeArr(result, j);
    }

    private boolean isNatural(double n){
        if (n <= 0){
            return false;
        }
        double decimalPart = n - (int)n;
        return decimalPart == 0;
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

    private BigInteger factorial(double n){
        BigInteger f = BigInteger.valueOf((long)n);
        for(int i = 1; i < n; i++){
            f = f.multiply(BigInteger.valueOf((long)n - i));
        }
        return f;
    }

    public boolean am_i_wilson(double n) {
        if(!isPrime(n)){
            return false;
        }
        BigInteger sq = BigInteger.valueOf((long)n).multiply(BigInteger.valueOf((long)n));
        BigInteger fct = factorial(n-1).add(BigInteger.valueOf(1));
        BigInteger reminder = fct.remainder(sq);
        return reminder.equals(BigInteger.valueOf(0));
    }
    
}

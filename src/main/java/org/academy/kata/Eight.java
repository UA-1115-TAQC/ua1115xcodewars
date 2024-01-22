package org.academy.kata;

public interface Eight {
    int liters(double time);

    double getVolumeOfCuboid(final double length, final double width, final double height);

    float mpgToKPM(final float mpg);

    static int[] squareOrSquareRootStatic(int[] array){
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            double squareRoot = Math.sqrt(number);
            result[i] = (squareRoot == (int) squareRoot) ? (int) squareRoot : (number * number);
        }
        return result;
    }

    int[] countPositivesSumNegatives(int[] input);

    int stringToNumber(String str);

    double TwoDecimalPlaces(double number);

    int[] divisibleBy(int[] numbers, int divider);

    boolean am_i_wilson(double n);
}

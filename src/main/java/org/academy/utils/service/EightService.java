package org.academy.utils.service;

import org.academy.kata.Eight;
import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;

import java.util.Arrays;


public class EightService {

                private ConsoleReader reader;
                private Eight eightIml;

                public void callMethod(int id, Author author, ConsoleReader reader) {
                    setImplByAuthor(author);
                    setReader(reader);

                    switch (id) {
                        case 15 -> keepHydrated();
                        case 16 -> getVolumeOfCuboid();
                        case 17 -> mpgToKPM();
                        case 18 -> squareOrSquareRoot();
                        case 19 -> countPositivesSumNegatives();
                        case 20 -> stringToNumber();
                        case 21 -> TwoDecimalPlaces();
                        case 22 -> divisibleBy();
                        case 23 -> am_i_wilson();
        }
    }

    private void keepHydrated() {
        printChoiceMessage("Keep Hydrated!");
        System.out.println("Enter time in hours:");
        double t = reader.readDouble();
        System.out.println("You entered " + t + "\nResult of task: " + eightIml.liters(t));
    }

    private void getVolumeOfCuboid() {
        printChoiceMessage("Volume of a Cuboid");
        System.out.println("Enter first values - length");
        double l = reader.readDouble();
        System.out.println("Enter second values - width");
        double w = reader.readDouble();
        System.out.println("Enter third values - height");
        double h = reader.readDouble();
        System.out.println("You entered " + l + ", " + w + ", " + h + "\nResult of task: " + eightIml.getVolumeOfCuboid(l, w, h));

    }

    private void mpgToKPM() {
        printChoiceMessage("Miles per gallon to kilometers per liter");
        System.out.println("Enter miles which you'd like to convert into kilometers:");
        float m = reader.readFloat();
        System.out.println("You entered " + m + "\nResult of task: " + eightIml.mpgToKPM(m));

    }

    private void squareOrSquareRoot() {
        printChoiceMessage("Count of positives / sum of negatives");
        System.out.println("Enter elements of the array:");
        int[] array = reader.readIntArr();
        int[] result = eightIml.squareOrSquareRoot(array);
        System.out.println("You entered " + Arrays.toString(array) + "\nResult of task: " + Arrays.toString(result));

    }
    private void countPositivesSumNegatives() {
        printChoiceMessage("To square(root) or not to square(root)");
        System.out.println("Enter elements of the array:");
        int[] input = reader.readIntArr();
        int[] result = eightIml.countPositivesSumNegatives(input);
        System.out.println("You entered " + Arrays.toString(input) + "\nResult of task: " + Arrays.toString(result));
    }

    private void stringToNumber() {
        printChoiceMessage("Convert a String to a Number!");
        System.out.println("Enter a string to convert to a number:");
        String str = reader.readString();
        int result = eightIml.stringToNumber(str);
        System.out.println("You entered " + str + "\nResult of task: " + result);
    }


    public void TwoDecimalPlaces() {
        printChoiceMessage("Formatting decimal places");
        System.out.println("Enter a number that should be rounded to two decimal places:");
        double n = reader.readDouble();
        System.out.println("You entered " + n + "\nResult of task: " + eightIml.TwoDecimalPlaces(n));
    }


    public void divisibleBy() {
        printChoiceMessage("Find numbers which are divisible by given number");
        System.out.println("Enter elements of the array:");
        int[] input = reader.readIntArr();
        System.out.println("Enter divisor:");
        int number = reader.readInt();
        int[] result = eightIml.divisibleBy(input,number);
        System.out.println("You entered " + Arrays.toString(input) + ", divisor " + number + "\nResult of task: " + Arrays.toString(result));
    }


    public void am_i_wilson() {
        printChoiceMessage("Wilson primes. Check if the given number is a Wilson prime");
        System.out.println("Enter the number:");
        int number = reader.readInt();
        System.out.println("You entered " + number + "\nResult of task: " + eightIml.am_i_wilson(number));
    }

    public void setImplByAuthor(Author author) {
        if (eightIml == null || eightIml.getClass() != author.getSix().getClass())
            setEightIml(author.getEight());
    }

    private void setReader(ConsoleReader reader) {
        this.reader = reader;
    }

    public void setEightIml(Eight eightIml) {
        this.eightIml = eightIml;
    }

    private void printChoiceMessage(String task) {
        System.out.printf("You choose a task '%s'%n", task);
    }


}




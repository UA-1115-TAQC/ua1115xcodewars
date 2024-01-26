package org.academy.utils.service;

import org.academy.kata.Eight;
import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;


public class EightService {

    private ConsoleReader reader;
    private Eight eightIml;

    public void callMethod(int id, Author author, ConsoleReader reader) {
        setImplByAuthor(author);
        setReader(reader);

        switch (id) {
            case 15 -> liters();
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

    private void liters() {
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




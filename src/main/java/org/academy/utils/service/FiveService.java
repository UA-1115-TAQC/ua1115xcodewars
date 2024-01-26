package org.academy.utils.service;

import java.math.BigInteger;

import org.academy.kata.Five;
import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;

public class FiveService {
    private ConsoleReader reader;
    private Five fiveImpl;

    public void callMethod(int id, Author author, ConsoleReader reader) {
        setImplByAuthor(author);
        setReader(reader);

        switch (id) {
            case 7 -> gapInPrimes();
            case 8 -> trailingZeros();
            case 9 -> perimeterSquares();
            case 10 -> xForSum();
            case 11 -> findSmallest();
            case 12 -> artificialRain();
        }
    }

    private void perimeterSquares() {
        printChoiceMessage("Perimeter of squares.");

        System.out.println("Enter a positive integer as a parameter: ");
        BigInteger param = reader.readBigInteger();
        System.out.println("You entered " + param + "\nResult of task: " + fiveImpl.perimeter(param));
    }

    private void xForSum() {
        printChoiceMessage("X for Sum.");

        System.out.println("Enter a positive double as a parameter: ");
        double param = reader.readDouble();
        System.out.println("You entered " + param + "\nResult of task: " + fiveImpl.solve(param));
    }

    private void printChoiceMessage(String task) {
        System.out.printf("You chose a task '%s'%n", task);
    }

    private void setReader(ConsoleReader reader) {
        if (this.reader == null) {
            this.reader = reader;
        }
    }

    private void setImplByAuthor(Author author) {
        if (fiveImpl == null || fiveImpl.getClass() != author.getFive().getClass()) {
            fiveImpl = author.getFive();
        }
    }
}

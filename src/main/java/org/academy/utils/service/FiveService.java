package org.academy.utils.service;

import org.academy.kata.Five;
import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;

import java.math.BigInteger;
import java.util.Arrays;

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
        }
    }

private void gapInPrimes(){
        printChoiceMessage("Gap in Primes.");
        System.out.println("Enter an integer, which is greater than 2 or equals it. It will also indicate the gap we are looking for: ");
        int g = reader.readInt();
        System.out.println("Enter an integer m, which is greater than 2. It will also indicate the start of the search (m inclusive): ");
        long m = reader.readLong();
        System.out.println("Enter an integer n, which is greater than m or equals it. It will also indicate the the end of the search (n inclusive): ");
        long n = reader.readLong();
        System.out.println("You entered " + g + ", " + m + ", " + n + "\nResult of task: " + Arrays.toString(fiveImpl.gap(g, m, n)));
    }

    private void trailingZeros(){
        printChoiceMessage("Number of trailing zeros of N!");
        System.out.println("Enter an an integer, which will indicate the number, the number of trailing zeroes in the factorial of which we are looking for: ");
        int n = reader.readInt();
        System.out.println("You entered " + n + "\nResult of task: " + fiveImpl.zeros(n));
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

    private void findSmallest() {
        printChoiceMessage("Find the smallest resulting integer along with the indices of the swapped digits");
        System.out.println("Enter a long as a parameter: ");
        long param = reader.readLong();
        System.out.println("You've entered: " + param + "\n.");
        System.out.println("Result: The smallest number is " + fiveImpl.smallest(param)[0] + ", digits " + fiveImpl.smallest(param)[1] + " and " + fiveImpl.smallest(param)[2] + " got swapped.");
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

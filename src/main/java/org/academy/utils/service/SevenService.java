package org.academy.utils.service;

import org.academy.kata.Seven;
import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;

public class SevenService {
    private ConsoleReader reader;
    private Seven sevenImpl;

    public void callMethod(int id, Author author, ConsoleReader reader) {
        setImplByAuthor(author);
        setReader(reader);

        if (id == 12) {
            newAvg();
        } else {
            seriesSum();
        }
    }

    private void newAvg() {
        printChoiceMessage("Looking for a benefactor");
        System.out.print("Enter the array of donations divided by whitespaces (array of doubles): ");
        double[] arr = reader.readDoubleArr();
        System.out.print("Enter the average donation (double): ");
        double d = reader.readDouble();
        System.out.println("Result of task: " + sevenImpl.newAvg(arr, d));
    }

    private void seriesSum() {
        printChoiceMessage("Sum of the first nth term of Series");
        System.out.println("Enter int number as a parameter: ");
        int sum = reader.readInt();
        sevenImpl.seriesSum(sum);
    }

    private void printChoiceMessage(String task) {
        System.out.println("You chose task \"" + task + '\"');
    }

    private void setReader(ConsoleReader reader) {
        this.reader = reader;
    }

    private void setImplByAuthor(Author author) {
        if (sevenImpl == null || sevenImpl.getClass() != author.getSeven().getClass()) {
            setSevenImpl(author.getSeven());
        }
    }

    private void setSevenImpl(Seven sevenImpl) {
        this.sevenImpl = sevenImpl;
    }
}

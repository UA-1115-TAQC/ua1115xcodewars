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
        switch (id) {
            case 13 -> newAvg();
            case 14 -> seriesSum();
        }
    }

    private void newAvg() {
        printChoiceMessage("newAwg");
        System.out.print("Enter the array of donations divided by whitespaces (array of doubles): ");
        double[] arr = reader.readDoubleArr();
        System.out.print("Enter the average donation (double): ");
        double d = reader.readDouble();
        System.out.println("Result of task: " + sevenImpl.newAvg(arr, d));
    }

    private void seriesSum() {
        printChoiceMessage("seriesSum");
        System.out.println("Enter int number as a parameter: ");
        int sum = reader.readInt();
        sevenImpl.seriesSum(sum);
    }

    private void printChoiceMessage(String task) {
        System.out.println("You choosed task \"" + task + '\"');
    }

    private void setReader(ConsoleReader reader) {
        this.reader = reader;
    }

    private void setSevenImpl(Seven sevenImpl) {
        this.sevenImpl = sevenImpl;
    }

    private void setImplByAuthor(Author author) {
        if (sevenImpl == null || sevenImpl.getClass() != author.getSeven().getClass()) {
            setSevenImpl(author.getSeven());
        }
    }

}

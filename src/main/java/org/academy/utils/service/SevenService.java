package org.academy.utils.service;

import org.academy.kata.Seven;
import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;

public class SevenService {
    private ConsoleReader reader;
    private Seven sevenImpl;

    private void seriesSum() {
        printChoiceMessage("seriesSum");
        System.out.println("Enter int number as a parameter: ");
        int sum = reader.readInt();
        sevenImpl.seriesSum(sum);
    }

    public void callMethod(int id, Author author, ConsoleReader reader) {
        setImplByAuthor(author);
        setReader(reader);

        // Add switch with numeration for task. We should discuss it.
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

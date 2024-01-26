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

        // Add switch with numeration for task. We should discuss it.
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

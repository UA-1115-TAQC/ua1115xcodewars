package org.academy.utils.service;


import org.academy.kata.Six;
import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;

public class SixService {
    private ConsoleReader reader;
    private Six sixImpl;

    public void callMethod(int id, Author author, ConsoleReader reader) {
        setImplByAuthor(author);
        setReader(reader);

        switch (id) {
            case 1 -> rainFall();
            case 2 -> helpTheBookseller();
            case 3 -> rankingNBA();
            case 4 -> floatingPointApproximation();
            case 5 -> easyBalanceChecking();
            case 6 -> buildPileOfCubes();
        }
    }

    private void rainFall() {
        printChoiceMessage("rainFall");
        double mean = sixImpl.mean("", "");
        double variance = sixImpl.variance("", "");
    }

    private void helpTheBookseller() {
        printChoiceMessage("helpTheBookseller");
        sixImpl.stockSummary(new String[0], new String[0]);
    }

    private void rankingNBA() {
        printChoiceMessage("rankingNBA");

        System.out.println("Enter NBA result sheet as string:");
        String resSheet = reader.readString();

        System.out.println("Enter a name of NBA team:");
        String teamToFind = reader.readString();

        String result = sixImpl.nbaCup(resSheet, teamToFind);
        System.out.println("Input parameters: \nNBA result sheet: " + resSheet
                + "\nNBA team: " + teamToFind
                + "\nResult: " + result);
    }

    private void floatingPointApproximation() {
        printChoiceMessage("floatingPointApproximation");

        System.out.println("Enter decimal number as parameter:"); // 2.6e-08 result: 1.29999999155e-08
        double value = reader.readDouble();
        double result = sixImpl.f(value);
        System.out.println("You entered: " + value + "\nResult of task: " + result);
    }

    private void easyBalanceChecking() {
        printChoiceMessage("easyBalanceChecking");
        sixImpl.balance("");
    }

    private void buildPileOfCubes() {
        printChoiceMessage("buildPileOfCubes");
        long nb = sixImpl.findNb(0l);
    }

    private void printChoiceMessage(String task) {
        System.out.println("You choosed task \"" + task + '\"');
    }

    public void setImplByAuthor(Author author) {
        if (sixImpl == null || sixImpl.getClass() != author.getSix().getClass())
            setSixImpl(author.getSix());
    }

    private void setSixImpl(Six sixImpl) {
        this.sixImpl = sixImpl;
    }

    private void setReader(ConsoleReader reader) {
        this.reader = reader;
    }
}

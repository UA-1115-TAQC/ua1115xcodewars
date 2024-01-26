package org.academy.utils.controller;

import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;
import org.academy.utils.service.SixService;

public class MainController {
    private static MainController INSTANCE;
    private static final String ACTIONS = """
            1. show authors;
            2. choose author;
            3. show tasks;
            4. choose task;
            0. exit;""";
    private static final String TASKS = """ 
            1 rainFall
            2 helpTheBookseller
            3 rankingNBA
            4 floatingPointApproximation
            5 easyBalanceChecking
            6 buildPileOfCubes""";
    private final ConsoleReader reader;
    private final SixService sixService;

    private MainController(ConsoleReader reader, SixService sixService) {
        this.reader = reader;
        this.sixService = sixService;
    }

    public static MainController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainController(new ConsoleReader(), new SixService());
        }
        return INSTANCE;
    }

    public void entryPoint() {
        Author author = null;
        boolean flag = false;

        System.out.println("Welcome to \"Code Warriors\"");
        System.out.println("------------------------------");
        printActions();

        while (!flag) {
            System.out.println("------------------------------");
            System.out.println("Input the number of an action:");
            switch (reader.readInt()) {
                case 1 -> printAuthors();
                case 2 -> author = chooseAuthor();
                case 3 -> printTasks();
                case 4 -> chooseTask(author);
                case 0 -> flag = true;
                default -> printActions();
            }
        }
        System.out.println("program finished");
    }

    private void printActions() {
        System.out.println(ACTIONS);
    }

    private void printAuthors() {
        System.out.println("List of author:");
        Author.printAuthors();
    }

    private void printTasks() {
        System.out.println("List of tasks:");
        System.out.println(TASKS);
    }

    private Author chooseAuthor() {
        printAuthors();
        System.out.println("Input the number of an author:");
        int id = reader.readInt();
        Author authorById = Author.getAuthorById(id);

        if (authorById != null) {
            printChoiceMessage(authorById.getName());
            return authorById;
        }
        printExceptionMessage("Author", id);
        return null;
    }

    private void chooseTask(Author author) {
        if (author == null) {
            System.out.println("At first you have to select an author");
            return;
        }

        printTasks();
        System.out.println("------------------------");
        System.out.println("Input the number of task:");
        int taskId = reader.readInt();
        mapTask(taskId, author);
    }

    private void mapTask(int taskId, Author author) {
        if (taskId > 0 && taskId <= 6)
            sixService.callMethod(taskId, author, reader);
            // or else if(taskId > 6 && taskId <= 10)
            // sevenController ....
            // etc.
        else printExceptionMessage("Task", taskId);
    }

    private void printExceptionMessage(String obj, int reason) {
        System.out.println(obj + " with id " + reason + " doesn't exist");
    }

    private void printChoiceMessage(String obj) {
        System.out.println("You choosed \"" + obj + '\"');
    }
}
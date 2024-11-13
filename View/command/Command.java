package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public abstract class Command {

    String description;
    ConsoleNotebookView consoleNotebookView;

    public Command(ConsoleNotebookView consoleNotebookView) {
        this.consoleNotebookView = consoleNotebookView;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();

}

package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class Exit extends Command{

    public Exit(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Закрыть программу";
    }

    @Override
    public void execute() {
        consoleNotebookView.exit();
    }

}

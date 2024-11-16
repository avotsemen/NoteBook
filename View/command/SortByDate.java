package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class SortByDate extends Command {

public SortByDate(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Отсортировать по датам";
    }

    @Override
    public void execute() {
        consoleNotebookView.SortByDate();
    }
}

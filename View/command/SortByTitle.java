package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class SortByTitle extends Command{
public SortByTitle(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Отсортировать по заголовкам";
    }

    @Override
    public void execute() {
        consoleNotebookView.SortByTitle();
    }
}

package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class SafeToFile extends ImportExport{

    public SafeToFile(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Сохранить в файл";
    }

    @Override
    public void execute() {
        consoleNotebookView.SafeToFile();
    }
}

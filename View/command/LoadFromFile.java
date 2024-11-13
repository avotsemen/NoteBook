package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class LoadFromFile extends ImportExport{

    public LoadFromFile(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Загрузить из файла";
    }

    @Override
    public void execute() {
        consoleNotebookView.LoadFromFile();
    }
}

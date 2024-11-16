package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class ViewNote extends Command {

    public ViewNote(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Показать заметку";
    }

    @Override
    public void execute() {
        consoleNotebookView.viewNote();
    }

}
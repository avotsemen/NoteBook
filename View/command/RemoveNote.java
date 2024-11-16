package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class RemoveNote extends Command {

    public RemoveNote(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Удалить заметку";
    }

    @Override
    public void execute() {
        consoleNotebookView.removeNote();
    }

}
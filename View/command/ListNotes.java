package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class ListNotes extends Command {

    public ListNotes(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Список заметок";
    }

    @Override
    public void execute() {
        consoleNotebookView.listNotes();
    }

}

package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class AddNote extends Command {

    public AddNote(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Добавить новую заметку";
    }

    @Override
    public void execute() {
        consoleNotebookView.addNote();
    }

}

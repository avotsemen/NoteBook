package oop.NoteBook.View.command;

import oop.NoteBook.View.ConsoleNotebookView;

public class ImportExport extends Command {

    public ImportExport(ConsoleNotebookView consoleNotebookView) {
        super(consoleNotebookView);
        description = "Импорт/Экспорт записной книжки";
    }

    @Override
    public void execute() {
        consoleNotebookView.safe_load();
    }

}

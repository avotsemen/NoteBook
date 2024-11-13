package oop.NoteBook.View;

import java.util.ArrayList;
import java.util.List;

import oop.NoteBook.View.command.*;

public class ConsoleMenu {
    List<Command> commandList;
    List<Command> subCommandList;

    public ConsoleMenu(ConsoleNotebookView consoleNotebookView) {
        commandList = new ArrayList<>();
        commandList.add(new AddNote(consoleNotebookView));
        commandList.add(new ListNotes(consoleNotebookView));
        commandList.add(new ImportExport(consoleNotebookView));
        commandList.add(new Exit(consoleNotebookView));
    }

    String menu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choise) {
        Command command = commandList.get(choise-1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }


    }
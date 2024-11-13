package oop.NoteBook.View;

import java.util.ArrayList;
import java.util.List;

import oop.NoteBook.View.command.*;

public class ConsoleSubMenu {
    List<Command> subCommandList;

    public ConsoleSubMenu(ConsoleNotebookView consoleNotebookView) {
        subCommandList = new ArrayList<>();
        subCommandList.add(new SortByDate(consoleNotebookView));
        subCommandList.add(new SortByTitle(consoleNotebookView));
    }

    String subMenu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subCommandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(subCommandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choise) {
        Command command = subCommandList.get(choise-1);
        command.execute();
    }

    public int getSize() {
        return subCommandList.size();
    }


    }
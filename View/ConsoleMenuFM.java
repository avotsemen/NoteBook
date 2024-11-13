package oop.NoteBook.View;

import java.util.ArrayList;
import java.util.List;

import oop.NoteBook.View.command.*;

public class ConsoleMenuFM {
    List<Command> FMCommandList;

    public ConsoleMenuFM(ConsoleNotebookView consoleNotebookView) {
        FMCommandList = new ArrayList<>();
        FMCommandList.add(new SafeToFile(consoleNotebookView));
        FMCommandList.add(new LoadFromFile(consoleNotebookView));
    }

    String FMMenu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FMCommandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(FMCommandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choise) {
        Command command = FMCommandList.get(choise-1);
        command.execute();
    }

    public int getSize() {
        return FMCommandList.size();
    }


    }
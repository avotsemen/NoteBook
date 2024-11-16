package oop.NoteBook.View;

import java.util.List;
import java.util.Scanner;

import oop.NoteBook.View.command.*;

public class ConsoleMenu {
    private List<Command> commands;
    private ConsoleMenu parentMenu; // для возврата к родительскому меню
    private ConsoleNotebookView consoleNotebookView; // ссылка на представление

    public ConsoleMenu(List<Command> commands, ConsoleMenu parentMenu, ConsoleNotebookView consoleNotebookView) {
        this.commands = commands;
        this.parentMenu = parentMenu;
        this.consoleNotebookView = consoleNotebookView;
    }

    // создание основного меню
    public static ConsoleMenu createMainMenu(ConsoleNotebookView consoleNotebookView) {
        List<Command> mainCommands = List.of(
                new AddNote(consoleNotebookView),
                new ListNotes(consoleNotebookView),
                new ImportExport(consoleNotebookView),
                new Exit(consoleNotebookView));
        return new ConsoleMenu(mainCommands, null, consoleNotebookView);
    }

    // создание подменю для вывода списка заметок
    public ConsoleMenu createSubMenu() {
        List<Command> subCommands = List.of(
                new SortByDate(consoleNotebookView),
                new SortByTitle(consoleNotebookView));
        return new ConsoleMenu(subCommands, this, consoleNotebookView); // добавление ссылки на родительское меню
    }

    // создание подменю для импорта/экспорта
    public ConsoleMenu createFMMenu() {
        List<Command> subCommands = List.of(
                new SafeToFile(consoleNotebookView),
                new LoadFromFile(consoleNotebookView));
        return new ConsoleMenu(subCommands, this, consoleNotebookView); // добавление ссылки на родительское меню
    }

    // метод для отображения меню и обработки выбора пользователя
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите команду:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ". " + commands.get(i).getDescription());
        }

        if (parentMenu != null) {
            System.out.println("0. Вернуться к предыдущему меню");
        }

        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 0 && parentMenu != null) {
            parentMenu.displayMenu(); // возвращаемся к родительскому меню
            return; // завершаем выполнение текущего меню
        } else if (choice > 0 && choice <= commands.size()) {
            Command selectedCommand = commands.get(choice - 1);
            selectedCommand.execute();

            // Проверка для перехода в подменю, если команда требует его открытия
            if (selectedCommand instanceof ImportExport) {
                createFMMenu().displayMenu();
            } else if (selectedCommand instanceof ListNotes) {
                createSubMenu().displayMenu();
            }
        } else {
            System.out.println("Неверный выбор. Попробуйте снова.");
        }

    }

}

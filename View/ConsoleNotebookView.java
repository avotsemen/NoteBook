package oop.NoteBook.View;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import oop.NoteBook.Model.Notes.NoteBook;
import oop.NoteBook.Model.service.FileOperations;
import oop.NoteBook.Presenter.NotebookPresenter;

public class ConsoleNotebookView implements NotebookView {

    private Scanner scanner;
    private NotebookPresenter presenter;
    private boolean exit;
    private ConsoleMenu menu;
    private ConsoleSubMenu subMenu;
    private ConsoleMenuFM FMMenu;
    private NoteBook notebook;
    private FileOperations fileOperations;
    private NotebookView view;

    public ConsoleNotebookView() {

        this.exit = true;
        notebook = new NoteBook();
        fileOperations = new FileOperations();
        view = this;
        scanner = new Scanner(System.in);
        presenter = new NotebookPresenter(notebook, fileOperations, view);
        menu = new ConsoleMenu(this);
        subMenu = new ConsoleSubMenu(this);
        FMMenu = new ConsoleMenuFM(this);
    }


    @Override
    public void start() {
        while (exit) {

            System.out.println("Выберите действие:");
            printMenu();
        }
    }

    private void printMenu() {
        printNote(menu.menu());
        execute();
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommands = Integer.parseInt(line);
            if (checkCommand(numCommands)) {
                menu.execute(numCommands);
            }
        }
    }

    private void executeSubMenu() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommands = Integer.parseInt(line);
            if (checkCommand(numCommands)) {
                subMenu.execute(numCommands);
            }
        }
    }
    private void executeFMMenu() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommands = Integer.parseInt(line);
            if (checkCommand(numCommands)) {
                FMMenu.execute(numCommands);
            }
        }
    }
    private boolean checkCommand(int numCommands) {
        if (numCommands <= menu.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkTextForInt(String text) {
        return text.matches("[0-9]+");
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void exit() {
        exit = false;
    }

    public void listNotes() {
        printNote(subMenu.subMenu());
        executeSubMenu();
    }

    @Override
    public void printNote(String note) {

        System.out.println(note);
    }

    public void addNote() {
        System.out.println("Введите заголовок заметки:");
        String title = scanner.nextLine();
        System.out.println("Введите описание заметки:");
        String description = scanner.nextLine();

        // Формат для даты
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = null;
        boolean validDate = false;

        // Запрос даты до корректного ввода
        while (!validDate) {
            try {
                System.out.println("Введите дату (в формате дд-мм-гггг):");
                String dateInput = scanner.nextLine();
                date = LocalDate.parse(dateInput, dateFormatter); // Парсинг даты
                validDate = true; // Завершаем цикл при корректной дате
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Попробуйте еще раз.");
            }
        }
        // Формат для времени
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime time = null;
        boolean validTime = false;

        // Запрос времени до корректного ввода
        while (!validTime) {
            try {
                System.out.println("Введите время (в формате чч:мм):");
                String timeInput = scanner.nextLine();
                time = LocalTime.parse(timeInput, timeFormatter); // Парсинг времени
                validTime = true; // Завершаем цикл при корректной дате
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат времени. Попробуйте еще раз.");
            }
        }

        // Создаем заметку и добавляем ее в notebook
        presenter.createNote(date, time, title, description);
    }

    public void SortByDate() {
        presenter.sortByDate();
    }

    public void SortByTitle() {
        presenter.sortByTitle();
    }

    public void SafeToFile() {
        presenter.safeToFile();
    }

    public void safe_load() {
        printNote(FMMenu.FMMenu());
        executeFMMenu();
    }

    public void LoadFromFile() {
        presenter.loadFromFile();
    }

    @Override
    public void showSaveSuccess() {
        System.out.println("Заметки сохранены в файл 'notebook.dat'.");
        System.out.println();
    }

    @Override
    public void showSaveError(String errorMessage) {
        System.err.println("Ошибка при сохранении: " + errorMessage);
        System.out.println();
    }

    @Override
    public void showLoadSuccess() {
        System.out.println("Заметки загружены из файла 'notebook.dat'.");
        System.out.println();
    }

    @Override
    public void showLoadError(String errorMessage) {
        System.err.println("Ошибка при загрузке: " + errorMessage);
        System.out.println();
    }

}

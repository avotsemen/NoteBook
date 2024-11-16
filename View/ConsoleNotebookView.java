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
    private ConsoleMenu mainMenu;
    private NoteBook notebook;
    private FileOperations fileOperations;
    private NotebookView view;

    public ConsoleNotebookView() {

        this.exit = true;
        this.notebook = new NoteBook();
        fileOperations = new FileOperations();
        this.view = this;
        scanner = new Scanner(System.in);
        presenter = new NotebookPresenter(notebook, fileOperations, view);
        this.mainMenu = ConsoleMenu.createMainMenu(this);
    }
    


    public void start() {
        while (exit) {
            if (mainMenu != null) {
                mainMenu.displayMenu();
            } else {
                System.out.println("Ошибка: меню не инициализировано.");
                exit();
            }
        }
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void exit() {
        exit = false;
    }

    public void listNotes() {
        mainMenu.createSubMenu();
    }

    public void safe_load() {
        mainMenu.createFMMenu();
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

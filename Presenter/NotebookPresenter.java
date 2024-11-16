package oop.NoteBook.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

import oop.NoteBook.Model.Notes.Note;
import oop.NoteBook.Model.Notes.NoteBook;
import oop.NoteBook.Model.service.FileOperationInterface;
import oop.NoteBook.View.NotebookView;

public class NotebookPresenter {

    private NoteBook notebook;
    private NotebookView view;
    private FileOperationInterface fileOperations;

    public NotebookPresenter(NoteBook notebook, FileOperationInterface fileOperations, NotebookView view) {
        this.notebook = new NoteBook();
        this.fileOperations = fileOperations;
        this.view = view;
    }

    public void createNote(LocalDate date, LocalTime time, String title, String description) {
        Note note = new Note(date, time, title, description);
        notebook.addNote(note);
    }

    public void listNotes() {
        notebook.listNotes();
    }

    public void safeToFile() {
        try {
            fileOperations.saveToFile(notebook, "notebook.dat");
            view.showSaveSuccess();
            System.out.println("Сохранено заметок: " + notebook.getNotes().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try {
            this.notebook = fileOperations.loadFromFile("notebook.dat");
            view.showLoadSuccess();
            int noteCount = notebook.getNotes().size();
            System.out.println("Количество загруженных заметок: " + noteCount);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByTitle() {
        Collections.sort(notebook.getNotes(), (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
        listNotes();

    }

    public void sortByDate() {
        Collections.sort(notebook.getNotes(), (p1, p2) -> {
            int dateComparison = p1.getDate().compareTo(p2.getDate());
            if (dateComparison != 0) {
                return dateComparison; // если даты разные, используем результат сравнения дат
            }
            // если даты одинаковые, сравниваем время
            return p1.getTime().compareTo(p2.getTime());
        });
        listNotes();
    }
}
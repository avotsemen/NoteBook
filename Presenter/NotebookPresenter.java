package oop.NoteBook.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import oop.NoteBook.Model.Notes.NoteBook;
import oop.NoteBook.Model.Notes.NoteBookOperation;
import oop.NoteBook.Model.service.FileOperationInterface;
import oop.NoteBook.View.NotebookView;

public class NotebookPresenter {

    private NoteBook notebook;
    private NotebookView view;
    private FileOperationInterface fileOperations;
    private NoteBookOperation operation;

    public NotebookPresenter(NoteBook notebook, FileOperationInterface fileOperations, NotebookView view) {
        this.notebook = notebook;
        this.fileOperations = fileOperations;
        this.view = view;
        operation = new NoteBookOperation();
    }

    public void createNote(LocalDate date, LocalTime time, String title, String description) {
        operation.createNote(date, time, title, description);
    }

    public void listNotes() {
        operation.listNotes();
    }

    public void sortByTitle() {
        operation.sortByTitle();
    }

    public void sortByDate() {
        operation.sortByDate();
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
}
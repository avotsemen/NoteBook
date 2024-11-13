package oop.NoteBook;

import oop.NoteBook.View.ConsoleNotebookView;

public class Main {

    public static void main(String[] args) {
        ConsoleNotebookView consoleNotebookView = new ConsoleNotebookView();
        consoleNotebookView.start();






        // NoteBook<Note> notebook = new NoteBook<>();


        // Note note1 = new Note("Title 1", "Description 1");
        // Note note2 = new Note(LocalDate.of(2024, 11, 05), LocalTime.of(10, 30), "Title 2", "Description 2");

        // notebook.addNote(note1);
        // notebook.addNote(note2);

        // // System.out.println(note1);
        // // System.out.println(note2);
        // //System.out.println(notebook.getNote(0));
        // // System.out.println(notebook.getNotesCount());
        // notebook.listNotes();

    }
}

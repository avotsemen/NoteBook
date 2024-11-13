package oop.NoteBook.Model.Notes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

public class NoteBookOperation {

    NoteBook notebook = new NoteBook();

    public void createNote(LocalDate date, LocalTime time, String title, String description) {
        Note note = new Note(date, time, title, description);
        notebook.addNote(note);
    }

    public void listNotes() {
        notebook.listNotes();
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

package oop.NoteBook.Model.Notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NoteBook  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Note> notes;

    public Object getNotes;
    
    public NoteBook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        this.notes.add(note);
        }

    public void removeNote(int index) {
        this.notes.remove(index);
    }
    

    public List<Note> getNotes() {
        return notes;
    }

    public void listNotes() {
        for (Note note : notes) {
            System.out.println(((Note) note).getDate() + " - " + ((Note) note).getTitle());
        }
        System.out.println();
    }

    public Note getNote(int index) {
        return notes.get(index);
    }
}

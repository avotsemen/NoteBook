package oop.NoteBook.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Note implements Serializable{

    public LocalDate date;
    public LocalTime time;
    public String title;
    public String description;
    
    public Note() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }
    
    public Note(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }
    
    public Note(LocalDate date, LocalTime time, String title, String description) {
        this.date = date;
        this.time = time;
        this.title = title;
        this.description = description;

    }

    public LocalDate getDate() {
        return date;
    }
    
    public LocalTime getTime() {
        return time;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Заметка{" +
                "дата: " + date +
                ", время: " + time +
                ", заголовок: '" + title + '\'' +
                ", описание: '" + description + '\'' +
                '}';
    }
        
}

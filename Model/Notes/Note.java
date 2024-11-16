package oop.NoteBook.Model.Notes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Note implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private LocalDate date;
    private LocalTime time;
    private String title;
    private String description;

    public Note() {
        this.date = LocalDate.now();
        this.time = LocalTime.now().withSecond(0).withNano(0);
    }

    public Note(String title) {
        this.title = title;
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

    // геттеры и сеттеры
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
        return "Заметка: "  + "\n" +
                "дата: " + date + "\n" +
                "время: " + time + "\n" +
                "заголовок: '" + title + '\'' + "\n" +
                "описание: '" + description + '\'' +
                "\n";
    }
}

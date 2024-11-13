package oop.NoteBook.Model.service;

import java.io.IOException;

import oop.NoteBook.Model.Notes.NoteBook;

public interface FileOperationInterface {
    void saveToFile(NoteBook notebook,String fileName) throws IOException;
    NoteBook loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}

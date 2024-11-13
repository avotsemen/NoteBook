package oop.NoteBook.Model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import oop.NoteBook.Model.Notes.NoteBook;

public class FileOperations implements FileOperationInterface {

    @Override
    public void saveToFile(NoteBook notebook, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(notebook);
        }
    }

    @Override
    public NoteBook loadFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (NoteBook) ois.readObject(); // считываем объект NoteBook из файла
        }
    }


}

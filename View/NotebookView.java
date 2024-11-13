package oop.NoteBook.View;

public interface NotebookView {
    void start();
    void printNote(String note);
    
    void showSaveSuccess();
    void showSaveError(String errorMessage);
    void showLoadSuccess();
    void showLoadError(String message);
}

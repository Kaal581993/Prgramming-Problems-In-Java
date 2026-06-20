package linkedlist.basic.intermediate.advance;

import java.util.LinkedList;

public class UndoRedo {
    private LinkedList<String> textHistory = new LinkedList<>();
    private LinkedList<String> redoHistory = new LinkedList<>();
    private String currentText = "";

    public void type(String text) {
        textHistory.push(currentText);
        currentText += text;
        redoHistory.clear();
        System.out.println("Current text: " + currentText);
    }

    public void undo() {
        if (!textHistory.isEmpty()) {
            redoHistory.push(currentText);
            currentText = textHistory.pop();
            System.out.println("Undo! Current text: " + currentText);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            textHistory.push(currentText);
            currentText = redoHistory.pop();
            System.out.println("Redo! Current text: " + currentText);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public static void main(String[] args) {
        // Problem 15: Implement undo-redo functionality.
        UndoRedo editor = new UndoRedo();
        editor.type("Hello ");
        editor.type("World!");
        editor.undo();
        editor.redo();
    }
}

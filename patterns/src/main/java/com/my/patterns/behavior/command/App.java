package com.my.patterns.behavior.command;

import com.my.patterns.behavior.command.impl.CopyCommand;
import com.my.patterns.behavior.command.impl.CutCommand;
import com.my.patterns.behavior.command.impl.PasteCommand;
import com.my.patterns.behavior.command.impl.UndoCommand;

import java.util.ArrayList;
import java.util.List;

public class App {
    private String clipboard;
    private List<Editor> editors = new ArrayList<>();
    private Editor activeEditor = new Editor();
    private CommandHistory history = new CommandHistory();

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public List<Editor> getEditors() {
        return editors;
    }

    public void addEditors(Editor editor) {
        this.editors.add(editor);
    }

    public Editor getActiveEditor() {
        return activeEditor;
    }

    public void setActiveEditor(Editor activeEditor) {
        this.activeEditor = activeEditor;
    }

    public AbstractCommand rollBack() {
        return history.pop();
    }

    public void saveBackup(AbstractCommand command) {
        history.push(command);
    }

    public void createGUI(){
        AbstractCommand copy = new CopyCommand(this, activeEditor);
        AbstractCommand cut = new CutCommand(this, activeEditor);
        AbstractCommand paste = new PasteCommand(this, activeEditor);
        AbstractCommand undo = new UndoCommand(this, activeEditor);
    }

    public void exeCureCommand(AbstractCommand command){
        history.push(command);
    }

    public AbstractCommand undo(){
        return history.pop();
    }
}

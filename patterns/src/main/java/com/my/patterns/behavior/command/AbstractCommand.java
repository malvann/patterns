package com.my.patterns.behavior.command;

public abstract class AbstractCommand {
    protected App app;
    protected Editor editor;
    protected String backup;

    protected AbstractCommand(App app, Editor editor){
        this.app = app;
        this.editor = editor;
    }

    public void save(String newText){
        backup = editor.getSelection();
        editor.setSelection(newText);
    }

    public void undo(){
        editor.setSelection(backup);
    }

    protected abstract void execute();
}

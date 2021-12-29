package com.my.patterns.behavior.command.impl;

import com.my.patterns.behavior.command.AbstractCommand;
import com.my.patterns.behavior.command.App;
import com.my.patterns.behavior.command.Editor;

public class CutCommand extends AbstractCommand {

    public CutCommand(App app, Editor editor) {
        super(app, editor);
    }

    @Override
    protected void execute() {
        app.saveBackup(this);
        app.setClipboard(editor.getSelection());
        editor.deleteSelection();
    }
}

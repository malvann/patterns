package com.my.patterns.behavior.command.impl;

import com.my.patterns.behavior.command.AbstractCommand;
import com.my.patterns.behavior.command.App;
import com.my.patterns.behavior.command.Editor;

public class CopyCommand extends AbstractCommand {

    public CopyCommand(App app, Editor editor) {
        super(app, editor);
    }

    @Override
    protected void execute() {
        app.setClipboard(editor.getSelection());
    }
}

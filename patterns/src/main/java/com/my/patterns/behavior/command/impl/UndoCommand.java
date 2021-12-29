package com.my.patterns.behavior.command.impl;

import com.my.patterns.behavior.command.AbstractCommand;
import com.my.patterns.behavior.command.App;
import com.my.patterns.behavior.command.Editor;

public class UndoCommand extends AbstractCommand {

    public UndoCommand(App app, Editor editor) {
        super(app, editor);
    }

    @Override
    protected void execute() {
        app.rollBack();
    }
}

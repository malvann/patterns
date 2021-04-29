package patterns.behavior.command.impl;

import patterns.behavior.command.AbstractCommand;
import patterns.behavior.command.App;
import patterns.behavior.command.Editor;

public class UndoCommand extends AbstractCommand {

    public UndoCommand(App app, Editor editor) {
        super(app, editor);
    }

    @Override
    protected void execute() {
        app.rollBack();
    }
}

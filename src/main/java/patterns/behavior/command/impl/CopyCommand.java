package patterns.behavior.command.impl;

import patterns.behavior.command.AbstractCommand;
import patterns.behavior.command.App;
import patterns.behavior.command.Editor;

public class CopyCommand extends AbstractCommand {

    public CopyCommand(App app, Editor editor) {
        super(app, editor);
    }

    @Override
    protected void execute() {
        app.setClipboard(editor.getSelection());
    }
}

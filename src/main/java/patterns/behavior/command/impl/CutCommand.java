package patterns.behavior.command.impl;

import patterns.behavior.command.AbstractCommand;
import patterns.behavior.command.App;
import patterns.behavior.command.Editor;

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

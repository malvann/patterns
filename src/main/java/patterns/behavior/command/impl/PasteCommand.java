package patterns.behavior.command.impl;

import patterns.behavior.command.AbstractCommand;
import patterns.behavior.command.App;
import patterns.behavior.command.Editor;

public class PasteCommand extends AbstractCommand {

    public PasteCommand(App app, Editor editor) {
        super(app, editor);
    }

    @Override
    protected void execute() {
        app.saveBackup(this);
        editor.setSelection(app.getClipboard());
    }
}

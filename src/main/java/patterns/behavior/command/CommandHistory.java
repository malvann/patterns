package patterns.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<AbstractCommand> commandList = new ArrayList<>();

    public void push(AbstractCommand command){
        commandList.add(command);
    }

    public AbstractCommand pop(){
        return commandList.remove(commandList.size()-1);
    }
}

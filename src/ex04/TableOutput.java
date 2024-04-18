package ex04;

import java.util.Stack;

// Class for implementing undo functionality
class UndoManager {
    private Stack<Command> commandStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandStack.push(command);
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            command.undo();
        } else {
            System.out.println("No more commands to undo.");
        }
    }
}

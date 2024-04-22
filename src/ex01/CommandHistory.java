package ex01;

import java.util.Stack;

public class CommandHistory {
    private Stack<String> history = new Stack<>();

    public void push(String command) {
        history.push(command);
    }

    public String pop() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}

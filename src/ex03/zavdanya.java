package ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Клас для роботи з командами
class CommandManager {
    private static CommandManager instance;
    private List<Command> commandHistory;
    Editor editor;

    private CommandManager() {
        commandHistory = new ArrayList<>();
        editor = new Editor();
    }

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    // Виконання команди
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }

    // Скасування останньої команди
    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
        } else {
            System.out.println("Немає команд для скасування.");
        }
    }

    // Очищення історії команд
    public void clearCommandHistory() {
        commandHistory.clear();
        System.out.println("Історія команд очищена.");
    }

    // Виведення історії команд
    public void printCommandHistory() {
        System.out.println("Історія команд:");
        System.out.println("+--------+--------+");
        System.out.println("| Число  | Дія    |");
        System.out.println("+--------+--------+");
        for (int i = 0; i < commandHistory.size(); i++) {
            Command command = commandHistory.get(i);
            System.out.printf("|  %-6d| %-8s|%n", command.getNumber(), command.getAction());
        }
        System.out.println("+--------+--------+");
    }

    // Клас для роботи з командами
    interface Command {
        void execute();

        void undo();

        int getNumber();

        String getAction();
    }

    // Конкретна реалізація команди: додавання числа
    static class AddNumberCommand implements Command {
        private Editor editor;
        private int number;

        public AddNumberCommand(Editor editor, int number) {
            this.editor = editor;
            this.number = number;
        }

        public void execute() {
            editor.addNumber(number);
        }

        public void undo() {
            editor.removeNumber(number);
        }

        public int getNumber() {
            return number;
        }

        public String getAction() {
            return "Додано";
        }
    }

    // Конкретна реалізація команди: видалення числа
    static class RemoveNumberCommand implements Command {
        private Editor editor;
        private int number;

        public RemoveNumberCommand(Editor editor, int number) {
            this.editor = editor;
            this.number = number;
        }

        public void execute() {
            editor.removeNumber(number);
        }

        public void undo() {
            editor.addNumber(number);
        }

        public int getNumber() {
            return number;
        }

        public String getAction() {
            return "Видалено";
        }
    }

    // Клас для роботи з редактором
    static class Editor {
        private List<Integer> numbers;

        public Editor() {
            numbers = new ArrayList<>();
        }

        public void addNumber(int number) {
            numbers.add(number);
        }

        public void removeNumber(int number) {
            numbers.remove(Integer.valueOf(number));
        }

        public void printNumbers() {
            System.out.println("Поточний стан чисел:");
            System.out.println("+--------+");
            System.out.println("|  Число |");
            System.out.println("+--------+");
            for (Integer number : numbers) {
                System.out.printf("|  %-6d|%n", number);
            }
            System.out.println("+--------+");
        }
    }
}

// Клас для тестування програми
public class zavdanya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = CommandManager.getInstance();

        while (true) {
            System.out.println("1. Додати число");
            System.out.println("2. Видалити число");
            System.out.println("3. Скасувати останню операцію");
            System.out.println("4. Вивести історію команд");
            System.out.println("5. Очистити історію команд");
            System.out.println("6. Завершити роботу");

            System.out.print("Введіть номер операції: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введіть число для додавання: ");
                    int addNumber = scanner.nextInt();
                    commandManager.executeCommand(new CommandManager.AddNumberCommand(commandManager.editor, addNumber));
                    break;
                case 2:
                    System.out.print("Введіть число для видалення: ");
                    int removeNumber = scanner.nextInt();
                    commandManager.executeCommand(new CommandManager.RemoveNumberCommand(commandManager.editor, removeNumber));
                    break;
                case 3:
                    commandManager.undoLastCommand();
                    break;
                case 4:
                    commandManager.printCommandHistory();
                    break;
                case 5:
                    commandManager.clearCommandHistory();
                    break;
                case 6:
                    System.out.println("Програма завершує роботу.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некоректний вибір.");
            }

            commandManager.editor.printNumbers();
        }
    }
}

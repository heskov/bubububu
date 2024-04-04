package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Клас для відображення результатів і роботи з ними.
 */
public class ViewResult {
    private static final String FNAME = "items.bin";
    private static final int DEFAULT_NUM = 10;
    private ArrayList<zavdanya_2_2> items = new ArrayList<zavdanya_2_2>();

    // Додано конструктор, який приймає значення за замовчуванням
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            // Використано конструктор з параметрами класу zavdanya_2_2
            items.add(new zavdanya_2_2(0.0, 0.0));
        }
    }

    // Метод для отримання значень items
    public ArrayList<zavdanya_2_2> getItems() {
        return items;
    }

    // Перевизначений метод viewInit
    public void viewInit() {
        init(Math.random() * 360.0);
    }

    // Перевизначений метод viewSave
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    // Перевизначений метод viewRestore
    @SuppressWarnings("unchecked")
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        items = (ArrayList<zavdanya_2_2>) is.readObject();
        is.close();
    }

    // Перевизначені методи
    public void viewHeader() {
        System.out.println("Results:");
    }

    public void viewBody() {
        for(zavdanya_2_2 item : items) {
            // Виправлено помилки виклику методів
            System.out.printf("(%.0f; %.3f) ", item.getX(), item.getY());
        }
        System.out.println();
    }

    public void viewFooter() {
        System.out.println("End.");
    }

    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }

    // Новий метод для ініціалізації значень
    private void init(double stepX) {
        double x = 0.0;
        for(zavdanya_2_2 item : items) {
            item.setXY(x, calc(x));
            x += stepX;
        }
    }

    // Метод для обчислення значення функції
    private double calc(double x) {
        return Math.sin(x * Math.PI / 180);
    }
}

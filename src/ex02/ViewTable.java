package ex02;

import java.util.Formatter;
import ex02.zavdanya_2_2;
import ex02.ViewResult;

public class ViewTable extends ViewResult {
    private int width;

    public void displayResult() {
        // Вивід заголовка таблиці
        viewHeader();

        // Вивід тіла таблиці
        viewBody();

        // Вивід підвалу таблиці
        viewFooter();
    }

    public void viewHeader() {
        outLine();
        outLineLn();
    }

    public void viewBody() {
        for (zavdanya_2_2 item : getItems()) {
            outItem(item.getX(), item.getY());
        }
    }

    public void viewFooter() {
        outLine();
        outLineLn();
    }

    private void outItem(double x, double y) {
        Formatter fmt = new Formatter();
        fmt.format("| %10.3f | %10.3f |\n", x, y);
        System.out.print(fmt.toString());
    }

    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    private void outLineLn() {
        outLine();
        System.out.println();
    }
}

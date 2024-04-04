package ex02;
import ex02.View;


/**
 * Виконання обчислень та відображення результатів.
 * Містить реалізацію статичного методу main().
 * 
 * @author xone
 * @version 3.0
 * @see Main#main
 */
public class Main extends ex02{
    /**
     * Ініціалізує поле view.
     * 
     * @param view об'єкт View
     */
    public Main(View view) {
        super();
        
    }

    /**
     * Викликає метод menu() при запуску програми.
     * 
     * @param args параметри запуску програми
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }

    private void menu() {
        // TODO Auto-generated method stub
    }
}

package ex03;

import java.io.*;

public class ViewableResult implements View, Serializable {
    private Item2d item;

    public ViewableResult() {
        this.item = new Item2d();
    }

    @Override
    public void viewInit() {
        // Реалізуйте генерацію випадкового числа або ініціалізацію за потреби
        // Це може виглядати, наприклад, як item = new Item2d(Math.random(), Math.random());
    }

    @Override
    public void viewShow() {
        // Виведення поточного стану item
        System.out.println("X: " + item.getX());
        System.out.println("Y: " + item.getY());
    }

    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("item.ser"));
        oos.writeObject(item);
        oos.close();
    }

    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("item.ser"));
        item = (Item2d) ois.readObject();
        ois.close();
    }

    @Override
    public void viewClose() {
        // Можливо, ви захочете закрити які-небудь потоки або ресурси тут
    }

    public Item2d getItem() {
        return item;
    }
}

package ex03;

import java.util.ArrayList;
import java.util.Collection;

public class ViewResult {

    private Collection<zavdanya_2_2> items;

    public ViewResult() {
        items = new ArrayList<>();
    }

    public void addItem(zavdanya_2_2 item) {
        items.add(item);
    }

    public Collection<zavdanya_2_2> getItems() {
        return items;
    }

    public void viewSave() {
        // Логіка для збереження результату
    }

    public void viewRestore() {
        // Логіка для відновлення результату
    }

    // Додаткові методи
}

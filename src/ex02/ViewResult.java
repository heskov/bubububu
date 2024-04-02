package ex02;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

public class ViewResult {

    @Test
    public void testCalc() {
        ViewResult view = new ViewResult();
        view.init(90.0);
        zavdanya_2_2 item = new zavdanya_2_2();

        int ctr = 0;
        item.setXY(0.0, 0.0);
        assertTrue("Очікувалася точка " + item + ", але було отримано " + view.getItems().get(ctr),
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(90.0, 1.0);
        assertTrue("Очікувалася точка " + item + ", але було отримано " + view.getItems().get(ctr),
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(180.0, 0.0);
        assertTrue("Очікувалася точка " + item + ", але було отримано " + view.getItems().get(ctr),
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(270.0, -1.0);
        assertTrue("Очікувалася точка " + item + ", але було отримано " + view.getItems().get(ctr),
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(360.0, 0.0);
        assertTrue("Очікувалася точка " + item + ", але було отримано " + view.getItems().get(ctr),
                view.getItems().get(ctr).equals(item));
    }

    private Object getItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItems'");
    }

    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();

        view1.init(Math.random() * 100.0);

        try {
            view1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        try {
            view2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        assertEquals(((Object) view1.getItems()).size(), view2.getItems().size());

        assertTrue("Елементи в колекціях відрізняються", view1.getItems().containsAll(view2.getItems()));
    }

    private void viewRestore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewRestore'");
    }
}
 
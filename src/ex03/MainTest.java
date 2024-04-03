package ex03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.List;

public class MainTest {

    @Test
    public void testCalc() {
        ViewResult view = new ViewResult();
        try {
            view.wait((long) (Math.random() * 100.0));
        } catch (InterruptedException e) {
            fail(e.getMessage()); 
        }
        zavdanya_2_2 item = new zavdanya_2_2();
        int ctr = 0;
        item.setXY(0.0, 0.0);

        List<?> items = (List<?>) view.getItems();
        assertTrue("expected:<" + item + "> but was:<" + items.get(ctr) + ">",
                    items.get(ctr).equals(item));
                
        item.setXY(90.0, 1.0);
        assertTrue("expected:<" + item + "> but was:<" + items.get(ctr) + ">",
                    items.get(ctr).equals(item));

        ctr++;
        item.setXY(180.0, 0.0);
        assertTrue("expected:<" + item + "> but was:<" + items.get(ctr) + ">",
                    items.get(ctr).equals(item));

        ctr++;
        item.setXY(270.0, -1.0);
        assertTrue("expected:<" + item + "> but was:<" + items.get(ctr) + ">",
                    items.get(ctr).equals(item));

        ctr++;
        item.setXY(360.0, 0.0);
        assertTrue("expected:<" + item + "> but was:<" + items.get(ctr) + ">",
                    items.get(ctr).equals(item));
    }

    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult();
        ViewResult view2 = new ViewResult();
        try {
            view1.wait();
        } catch (InterruptedException e) {
            fail(e.getMessage()); 
        }
        try {
            view1.viewSave();
            view2.viewRestore();
        } catch (Exception e) {
            fail(e.getMessage()); 
        }
        assertEquals(view1.getItems().size(), view2.getItems().size());
        assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
    }
}

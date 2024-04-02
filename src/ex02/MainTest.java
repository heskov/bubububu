package ex02;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import ex02.zavdanya_2_2;
/** Выполняет тестирование
* разработанных классов.
* @author xone
* @version 2.0
*/
public class MainTest {
/** Проверка основной функциональности класса {@linkplain ViewResult} */
@Test
public void testCalc() {
ViewResult view = new ViewResult(5);
view.init(90.0);
zavdanya_2_2 item = new zavdanya_2_2();
int ctr = 0;
item.setXY(0.0, 0.0);
assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",

view.getItems().get(ctr).equals(item));

ctr++;
item.setXY(90.0, 1.0);
assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",

view.getItems().get(ctr).equals(item));

ctr++;
item.setXY(180.0, 0.0);
assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",

view.getItems().get(ctr).equals(item));

ctr++;
item.setXY(270.0, -1.0);
assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",

view.getItems().get(ctr).equals(item));

ctr++;
item.setXY(360.0, 0.0);
assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",

view.getItems().get(ctr).equals(item));
}
/** Проверка сериализации. Корректность восстановления данных. */
@Test
public void testRestore() {
ViewResult view1 = new ViewResult(1000);
ViewResult view2 = new ViewResult();
// Вычислим значение функции со случайным шагом приращения аргумента
view1.init(Math.random()*100.0);
// Сохраним коллекцию view1.items
try {
view1.viewSave();
} catch (IOException e) {
Assert.fail(e.getMessage());
}
// Загрузим коллекцию view2.items
try {
view2.viewRestore();
} catch (Exception e) {
Assert.fail(e.getMessage());
}
// Должны загрузить столько же элементов, сколько сохранили
assertEquals(view1.getItems().size(), view2.getItems().size());
// Причем эти элементы должны быть равны.
// Для этого нужно определить метод equals
assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
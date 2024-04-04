package ex02;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import ex02.zavdanya_2_2;

/**
 * Виконує тестування розроблених класів.
 * 
 * author xone
 * version 3.0
 */
public class MainTest {

/** Выполняет тестирование
* разработанных классов.
* @author xone
* @version 3.0
*/
/** Проверка основной функциональности класса {@linkplain ViewTable} */
@Test
public void testCalc() {
ViewTable tbl = new ViewTable(10, 5);
assertEquals(10, tbl.getWidth());
assertEquals(5, tbl.getItems().size());
tbl.init(40, 90.0);
zavdanya_2_2 zavdanya_2_2 = new zavdanya_2_2(0, 0);
int ctr = 0;
String item;
item.setXY(0.0, 0.0);
assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",

tbl.getItems().get(ctr).equals(item));


ctr++;
item.setXY(90.0, 1.0);
assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",

tbl.getItems().get(ctr).equals(item));

ctr++;
item.setXY(180.0, 0.0);
assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",

tbl.getItems().get(ctr).equals(item));

ctr++;
item.setXY(270.0, -1.0);
assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",

tbl.getItems().get(ctr).equals(item));

ctr++;
item.setXY(360.0, 0.0);
assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",

tbl.getItems().get(ctr).equals(item));
}
/** Проверка сериализации. Корректность восстановления данных. */
@Test
public void testRestore() {
ViewTable tbl1 = new ViewTable(10, 1000);
ViewTable tbl2 = new ViewTable(0, 0);
// Вычислим значение функции со случайным шагом приращения аргумента
tbl1.init(30, Math.random()*100.0);
// Сохраним коллекцию tbl1.items
try {
tbl1.viewSave();
} catch (IOException e) {
Assert.fail(e.getMessage());
}
// Загрузим коллекцию tbl2.items
try {
tbl2.viewRestore();
} catch (Exception e) {
Assert.fail(e.getMessage());
}
// Должны загрузить столько же элементов, сколько сохранили
assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
// Причем эти элементы должны быть равны.
// Для этого нужно определить метод equals
assertTrue("containsAll()", tbl1.getItems().containsAll(tbl2.getItems()));
}
}
    // Тести для класу ViewTable
    // ...
}

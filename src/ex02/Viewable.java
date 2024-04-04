package ex02;

import java.io.IOException;

/** 
 * Product
 * (шаблон проєктування Factory Method)
 * Інтерфейс "фабрикованих" об'єктів.
 * Об'являє методи відображення об'єктів.
 * 
 * Автор: xone
 * Версія: 1.0
 */
public interface Viewable {
    /** Отображає заголовок */
    public void viewHeader();
    /** Отображає основну частину */
    public void viewBody();
    /** Отображає закінчення */
    public void viewFooter();
    /** Отображає об'єкт цілком */
    public void viewShow();
    /** Виконує ініціалізацію */
    public void viewInit();
    /** Зберігає дані для подальшого відновлення */
    public void viewSave() throws IOException;
    /** Відновлює раніше збережені дані */
    public void viewRestore() throws Exception;
}

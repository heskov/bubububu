package ex02;


// У файлі ViewableTable.java

public class ViewableTable extends ViewableResult{
    
    public View getView() {
        // Реалізація методу getView()
            return new ViewTable();
    }
}

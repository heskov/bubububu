package ex01;

import java.io.Serializable;

public interface TableHandler extends Serializable {
    void saveTable(String table);
    String restoreTable();
    void saveTableToFile(String table);
}

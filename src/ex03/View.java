package ex03;

import java.io.*;

public interface View {
    void viewInit();
    void viewShow();
    void viewSave() throws IOException;
    void viewRestore() throws Exception;
}

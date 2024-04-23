package ex01;

public class TableHandlerFactory {
    public static FileTableHandler createTableHandler() {
        return new FileTableHandler();
    }
}

package ex04;


public class ViewTable implements View {
    private final Result result = new Result();

    public void viewHeader() {
        System.out.printf("| %-7s| %-11s |\n", "Число", "Кількість");
    }

    public void viewBody() {
        viewFooter();
        for (int i = 0; i < 10; i++) {
            System.out.printf("| %-7d| %-11d |\n", i, result.getResult()[i]);
        }
        viewFooter();
    }

    public void viewFooter() {
        System.out.println("+" + "-".repeat(8) + "+-" + "-".repeat(12) + "+");
    }

    public void viewShow() {
        viewFooter();
        viewHeader();
        viewBody();
    }

    public void viewInit(int number) {
        result.setNumber(number);
    }
}

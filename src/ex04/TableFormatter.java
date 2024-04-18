package ex04;

// Class for formatting tables
public class TableFormatter {
    public static void displayTable(int[][] table) {
        for (int[] row : table) {
            System.out.printf("%d: %d | ", row[0], row[1]);
        }
        System.out.println();
    }
}

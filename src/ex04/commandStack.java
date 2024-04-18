package ex04;

// Class for formatting tables
class TableFormatter {
    public static void displayTable(int[][] table) {
        for (int[] row : table) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}

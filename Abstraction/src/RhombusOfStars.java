import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 1; row <= n; row++) {
            printRow(n, row);
        }
        for (int row = n - 1; row > 0; row--) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        printSpace(n - row, " ");
        printSpace(row, "* ");
        System.out.println();
    }

    private static void printSpace(int width, String str) {
        for (int i = 0; i < width; i++) {
            System.out.print(str);
        }
    }
}

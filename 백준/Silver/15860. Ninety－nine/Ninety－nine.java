import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        System.out.println(x);
        while (true) {
            int y = scanner.nextInt();
            if (y >= 99) break;
            if (y % 3 == 1) {
                x = y + 1;
            } else {
                x = y + 2;
            }
            if (x >= 99) {
                System.out.println(99);
                break;
            } else {
                System.out.println(x);
            }
        }
        scanner.close();
    }
}
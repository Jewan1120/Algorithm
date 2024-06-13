import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        while (true) {
            if (x % 3 == 0) x += (random.nextInt(2) + 1);
            else if (x % 3 == 1) x += 2;
            else if (x % 3 == 2) x += 1;
            System.out.println(x);
            if (x >= 99) break;
            x = scanner.nextInt();
            if (x >= 99) break;
        }
        scanner.close();
    }
}
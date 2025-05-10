import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double w = scanner.nextDouble();
        double v = scanner.nextDouble();
        System.out.println((w / v >= a) ? 1 : 0);
        scanner.close();
    }
}
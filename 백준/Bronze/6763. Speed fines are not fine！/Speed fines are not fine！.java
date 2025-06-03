import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a >= b) {
			System.out.println("Congratulations, you are within the speed limit!");
		}else {
			if(1 <= b - a && b - a <= 20) {
				System.out.println("You are speeding and your fine is $100.");
			}else if(21 <= b - a && b - a <= 30) {
				System.out.println("You are speeding and your fine is $270.");
			}else if(31 <= b - a) {
				System.out.println("You are speeding and your fine is $500.");
			}
		}
		sc.close();
	}
}
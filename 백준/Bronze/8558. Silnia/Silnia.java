import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m = 1;
		
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			m *= i;
			m = m % 10;
		}
		
		System.out.println(m);
		sc.close();
	}
}
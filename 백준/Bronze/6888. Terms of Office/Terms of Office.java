import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int i = a; i <= b; i = i + 60) {
			System.out.println("All positions change in year " + i);
		}
		sc.close();
	}
}
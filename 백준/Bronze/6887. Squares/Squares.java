import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int i;
		for(i = 1; i <= a; i++) {
			if(i * i > a) {
				break;
			}
		}
		
		System.out.println("The largest square has side length " + (i - 1) + ".");
		sc.close();
	}
}
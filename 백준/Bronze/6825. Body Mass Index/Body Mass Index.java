import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double weight = sc.nextDouble();
		double height = sc.nextDouble();
		double BMI = weight / (height * height);
		
		if(BMI > 25) {
			System.out.println("Overweight");
		}else if(18.5 <= BMI && BMI <= 25) {
			System.out.println("Normal weight");
		}else {
			System.out.println("Underweight");
		}
		sc.close();
	}
}
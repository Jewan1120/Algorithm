import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String a = sc.next();
			
			if(a.equals("CU")) {
				System.out.println("see you");
			}else if(a.equals(":-)")) {
				System.out.println("I’m happy");
			}else if(a.equals(":-(")) {
				System.out.println("I’m unhappy");
			}else if(a.equals(";-)")) {
				System.out.println("wink");
			}else if(a.equals(":-P")) {
				System.out.println("stick out my tongue");
			}else if(a.equals("(~.~)")) {
				System.out.println("sleepy");
			}else if(a.equals("TA")) {
				System.out.println("totally awesome");
			}else if(a.equals("CCC")) {
				System.out.println("Canadian Computing Competition");
			}else if(a.equals("CUZ")) {
				System.out.println("because");
			}else if(a.equals("TY")) {
				System.out.println("thank-you");
			}else if(a.equals("YW")) {
				System.out.println("you’re welcome");
			}else if(a.equals("TTYL")) {
				System.out.println("talk to you later");
			}else {
				System.out.println(a);
			}
		}
		sc.close();
	}
}
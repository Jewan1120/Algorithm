import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str);
		if(!str.contains("7"))
			if(n % 7 != 0)
				System.out.println(0);
			else
				System.out.println(1);
		else
			if(n % 7 != 0)
				System.out.println(2);
			else
				System.out.println(3);
	}
}
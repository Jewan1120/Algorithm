import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		char[] cArr = br.readLine().toCharArray();
		for (char c : cArr)
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				cnt++;
		System.out.println(cnt);
	}
}
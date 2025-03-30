import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		hs.add("Never gonna give you up");
		hs.add("Never gonna let you down");
		hs.add("Never gonna run around and desert you");
		hs.add("Never gonna make you cry");
		hs.add("Never gonna say goodbye");
		hs.add("Never gonna tell a lie and hurt you");
		hs.add("Never gonna stop");
		while (n-- > 0)
			if (!hs.contains(br.readLine())) {
				System.out.println("Yes");
				return;
			}
		System.out.println("No");
	}
}
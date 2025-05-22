import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		int[] arr = new int[26];
		for (char c : cArr)
			arr[c - 'a']++;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++)
			sb.append(arr[i]).append(" ");
		System.out.println(sb);
	}
}
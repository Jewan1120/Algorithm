import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int tenCm[];
	static StringBuilder answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int jari = 0;
		int total = -1;
		for (int i = 1; i <= 10; i++) {
			total += nCm(10, i);
			if (total >= n) {
				jari = i;
				break;
			}
		}
		int m = n;
		for (int i = 1; i < jari; i++)
			m -= nCm(10, jari - i);
		find(jari, m);
		if (answer.toString().length() == 0)
			answer.append(-1);
		System.out.println(answer);
	}

	public static int nCm(int n, int m) {
		int now = 1;
		for (int i = 0; i < m; i++) {
			now *= (n - i);
		}
		for (int i = m; i > 0; i--) {
			now /= i;
		}
		return now;
	}

	public static void find(int jari, int rest) {
		if (jari == 0) {
			return;
		}
		int now = jari - 1;
		while (rest >= nCm(now + 1, jari)) {
			now++;
		}
		rest -= nCm(now, jari);
		answer.append(now);
		find(jari - 1, rest);
	}
}

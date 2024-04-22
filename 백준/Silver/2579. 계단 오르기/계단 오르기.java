import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        int[] dp = new int[n + 1];
        dp[1] = stairs[1];
        if (n == 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        if (n >= 3) {
            dp[2] = stairs[1] + stairs[2];
            dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
            for (int i = 4; i <= n; i++) {
                dp[i] = stairs[i] + Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]);
            }
        }
        System.out.println(dp[n]);
    }
}
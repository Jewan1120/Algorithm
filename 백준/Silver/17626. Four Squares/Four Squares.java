import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 3];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = (int) Math.min(dp[i], dp[i - j * j]);
            }
            dp[i]++;
        }
        System.out.println(dp[n]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 6;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            arr[i] = m;
            max = Math.max(max, m);
        }
        long[] dp = new long[max + 1];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        for (int i : arr) {
            System.out.println(dp[i]);
        }
    }
}
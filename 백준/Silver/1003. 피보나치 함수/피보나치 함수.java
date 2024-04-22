import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int h = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            h = Math.max(h, x);
        }
        int[][] dp = new int[41][2];
        dp[0] = new int[] {1, 0};
        dp[1] = new int[] {0, 1};
        for (int i = 2; i <= h; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }
        StringBuilder sb;
        for (int i : arr) {
            sb = new StringBuilder();
            sb.append(dp[i][0]).append(" ").append(dp[i][1]);
            System.out.println(sb.toString());
        }
    }
}
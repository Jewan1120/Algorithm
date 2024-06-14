import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int n = Integer.parseInt(br.readLine());
        int[] dp = {1, 1, 1};
        for (int i = 2; i <= n; i++) {
            dp[2] = (dp[0] + dp[1]) % 15746;
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        System.out.println(dp[2]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                int min = 1_000_001;
                for (int k = 0; k < 3; k++) {
                    if (i == 0 || k == j)
                        continue;
                    min = Math.min(min, dp[i][j] + dp[i - 1][k]);
                }
                if (min != 1_000_001) {
                    dp[i][j] = min;
                }
            }
        }
        int min = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(min);
        br.close();
    }
}
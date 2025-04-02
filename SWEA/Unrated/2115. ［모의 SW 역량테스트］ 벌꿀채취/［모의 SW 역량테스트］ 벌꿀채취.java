import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m, c;
    static int[][] honey, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            honey = new int[n][n];
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    honey[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j <= n - m; j++)
                    dp[i][j] = recursive(0, i, j, 0, 0);

            int maxProfit = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j <= n - m; j++)
                    for (int k = i; k < n; k++)
                        for (int l = 0; l <= n - m; l++) {
                            if (i == k && j + m > l)
                                continue;
                            maxProfit = Math.max(maxProfit, dp[i][j] + dp[k][l]);
                        }
            sb.append("#").append(tc).append(" ").append(maxProfit).append("\n");
        }
        System.out.println(sb);
    }

    private static int recursive(int depth, int y, int x, int sum, int profit) {
        if (sum > c)
            return 0;
        if (depth == m)
            return profit;
        int include = recursive(depth + 1, y, x, sum + honey[y][x + depth], profit + (int) Math.pow(honey[y][x + depth], 2));
        int exclude = recursive(depth + 1, y, x, sum, profit);
        return Math.max(include, exclude);
    }
}
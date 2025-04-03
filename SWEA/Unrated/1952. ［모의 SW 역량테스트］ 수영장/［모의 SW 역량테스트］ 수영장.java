import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[] duration = { 0, 1, 3, 12 };
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int[] cost = new int[4];
            for (int i = 0; i < 4; i++)
                cost[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] plan = new int[13], dp = new int[13];
            for (int i = 1; i <= 12; i++)
                plan[i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= 12; i++) {
                dp[i] = dp[i - 1] + plan[i] * cost[0];
                for (int j = 1; j < 3; j++) {
                    if (i >= duration[j])
                        dp[i] = Math.min(dp[i], dp[i - duration[j]] + cost[j]);
                }
            }
            dp[12] = Math.min(dp[12], cost[3]);
            sb.append("#").append(tc).append(" ").append(dp[12]).append("\n");
        }
        System.out.println(sb);
    }
}

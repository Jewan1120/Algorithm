import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] score = new int[n], calorie = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[l + 1];
            for (int i = 0; i < n; i++)
                for (int j = l; j >= calorie[i]; j--)
                    dp[j] = Math.max(dp[j], dp[j - calorie[i]] + score[i]);
            sb.append("#").append(tc).append(" ").append(dp[l]).append("\n");
        }
        System.out.println(sb);
    }
}
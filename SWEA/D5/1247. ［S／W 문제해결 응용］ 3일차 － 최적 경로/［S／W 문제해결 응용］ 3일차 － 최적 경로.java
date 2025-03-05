import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static final int INF = Integer.MAX_VALUE;
    static int n;
    static int[][] adj, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[][] locations = new int[n + 2][2];
            for (int i = 0; i < n + 2; i++)
                locations[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            adj = new int[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++)
                for (int j = 0; j < n + 2; j++)
                    adj[i][j] = calDistance(locations[i], locations[j]);
            dp = new int[n + 2][1 << (n + 2)];
            for (int i = 0; i < n + 2; i++)
                Arrays.fill(dp[i], -1);
            int totalDistance = tsp(0, 1);
            sb.append("#").append(tc).append(" ").append(totalDistance).append("\n");
        }
        System.out.println(sb);
    }

    private static int tsp(int city, int visited) {
        if (visited == (1 << n + 2) - 1)
            return adj[city][1];
        if (dp[city][visited] != -1)
            return dp[city][visited];
        int distance = INF, temp = 0;
        for (int nextCity = 0; nextCity < n + 2; nextCity++) {
            if ((visited & (1 << nextCity)) != 0)
                continue;
            temp = adj[city][nextCity] + tsp(nextCity, visited | (1 << nextCity));
            distance = Math.min(distance, temp);
        }
        dp[city][visited] = distance;
        return distance;
    }

    private static int calDistance(int[] A, int[] B) {
        return Math.abs(A[0] - B[0]) + Math.abs(A[1] - B[1]);
    }
}

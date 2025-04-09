import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] adj = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(adj[i], Integer.MAX_VALUE >> 2);
                adj[i][i] = 0;
                for (int j = 0; j < n; j++) {
                    int w = Integer.parseInt(st.nextToken());
                    if (w != 0)
                        adj[i][j] = w;
                }
            }
            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++) {
                    if (k == i)
                        continue;
                    for (int j = 0; j < n; j++) {
                        if (k == j || i == j)
                            continue;
                        if (adj[i][j] > adj[i][k] + adj[k][j])
                            adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            int minWeight = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int weight = 0;
                for (int j = 0; j < n; j++)
                    weight += adj[i][j];
                minWeight = Math.min(minWeight, weight);
            }
            sb.append("#").append(tc).append(" ").append(minWeight).append("\n");
        }
        System.out.println(sb);
    }
}

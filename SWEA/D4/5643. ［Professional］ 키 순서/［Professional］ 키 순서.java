import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int[][] adj = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a][b] = 1;
                adj[b][a] = -1;
            }
            for (int k = 1; k < n + 1; k++)
                for (int i = 1; i < n + 1; i++) {
                    if (i == k)
                        continue;
                    for (int j = 1; j < n + 1; j++) {
                        if (j == k || i == j)
                            continue;
                        if (adj[i][k] == 1 && adj[k][j] == 1) {
                            adj[i][j] = 1;
                            adj[j][i] = -1;
                        }
                        if (adj[i][k] == -1 && adj[k][j] == -1) {
                            adj[i][j] = -1;
                            adj[j][i] = 1;
                        }
                    }
                }
            int cnt = 0;
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++) {
                    if (i == j)
                        continue;
                    if (adj[i][j] == 0) {
                        cnt++;
                        break;
                    }
                }
            sb.append("#").append(tc).append(" ").append(n - cnt).append("\n");
        }
        System.out.println(sb);
    }
}

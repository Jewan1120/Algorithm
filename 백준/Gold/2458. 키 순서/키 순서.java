import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++)
            edges[i][i] = 2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u][v] = 1;
            edges[v][u] = -1;
        }
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++) {
                    if (edges[i][k] == 1 && edges[k][j] == 1)
                        edges[i][j] = 1;
                    if (edges[i][k] == -1 && edges[k][j] == -1)
                        edges[i][j] = -1;
                }
        System.out.println(calculate());
    }

    private static int calculate() {
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            boolean flag = true;
            for (int j = 1; j < n + 1; j++)
                if (edges[i][j] == 0) {
                    flag = false;
                    break;
                }
            if (flag)
                cnt++;
        }
        return cnt;
    }
}
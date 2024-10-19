import java.util.Arrays;

public class Main {

    static final int INF = 100_001;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), b = read();
            graph[u][v] = 0;
            graph[v][u] = b == 1 ? 0 : 1;
        }
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
        int k = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int u = read(), v = read();
            sb.append(graph[u][v]).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
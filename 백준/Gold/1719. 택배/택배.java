import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[][] graph = new int[n + 1][n + 1];
        int[][] tracking = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE >> 1);
            graph[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            tracking[u][v] = v;
            tracking[v][u] = u;
            graph[u][v] = w;
            graph[v][u] = w;
        }
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        tracking[i][j] = tracking[i][k];
                    }
                }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    sb.append("-");
                else
                    sb.append(tracking[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
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
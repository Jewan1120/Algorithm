public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[][] dist = new int[n + 1][n + 1];
        int max = Integer.MAX_VALUE >> 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = max;
            }
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int v = read();
            int u = read();
            int w = read();
            dist[v][u] = Math.min(dist[v][u], w);
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(dist[i][j] != max ? dist[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
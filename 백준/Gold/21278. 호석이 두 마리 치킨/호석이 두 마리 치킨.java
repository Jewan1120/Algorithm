import java.util.Arrays;

public class Main {
    static final int INF = 1000000000;
    static int n, m;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            dist[a][b] = dist[b][a] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int min = INF;
        int c1 = 0, c2 = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int sum = 0;
                for (int k = 1; k <= n; k++) {
                    sum += Math.min(dist[k][i], dist[k][j]) * 2;
                }
                if (sum < min) {
                    min = sum;
                    c1 = i;
                    c2 = j;
                }
            }
        }
        System.out.println(c1 + " " + c2 + " " + min);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
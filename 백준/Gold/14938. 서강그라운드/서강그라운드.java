import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), r = read();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            arr[i] = read();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], 1000);
            dist[i][i] = 0;
        }
        for (int i = 0; i < r; i++) {
            int u = read(), v = read(), w = read();
            dist[u][v] = w;
            dist[v][u] = w;
        }
        int max = 0;
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] <= m)
                    cnt += arr[j];
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
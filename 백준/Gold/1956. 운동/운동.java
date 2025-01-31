import java.util.Arrays;

public class Main {

    static final int INF = Integer.MAX_VALUE >> 2;

    public static void main(String[] args) throws Exception {
        int v = read(), e = read();
        int[][] adj = new int[v][v];
        for (int i = 0; i < v; i++) {
            Arrays.fill(adj[i], INF);
            adj[i][i] = 0;
        }
        for (int i = 0; i < e; i++) {
            int a = read(), b = read(), c = read();
            adj[a - 1][b - 1] = c;
        }
        for (int k = 0; k < v; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    if (adj[i][j] > adj[i][k] + adj[k][j])
                        adj[i][j] = adj[i][k] + adj[k][j];
        int min = INF;
        for (int i = 0; i < v - 1; i++)
            for (int j = i + 1; j < v; j++)
                min = Math.min(min, adj[i][j] + adj[j][i]);
        System.out.println(min != INF ? min : -1);
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
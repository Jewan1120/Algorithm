public class Main {

    static int n, k;
    static int[][] dist;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        dist = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = read();
        for (int l = 0; l < n; l++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][j] > dist[i][l] + dist[l][j])
                        dist[i][j] = dist[i][l] + dist[l][j];
        recursive(0, k, 1 << k);
        System.out.println(min);
    }

    private static void recursive(int cost, int cur, int visited) {
        if (visited == (1 << n) - 1) {
            min = Math.min(min, cost);
            return;
        }
        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) != 0)
                continue;
            recursive(cost + dist[cur][next], next, visited | (1 << next));
        }
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
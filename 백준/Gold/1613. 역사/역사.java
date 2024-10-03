public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            int u = read(), v = read();
            distance[u][v] = -1;
            distance[v][u] = 1;
        }
        for (int p = 1; p < n + 1; p++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++) {
                    if (distance[i][p] == -1 && distance[p][j] == -1)
                        distance[i][j] = -1;
                    else if (distance[i][p] == 1 && distance[p][j] == 1)
                        distance[i][j] = 1;
                }
        int s = read();
        StringBuilder sb = new StringBuilder();
        while (s-- > 0) {
            int u = read(), v = read();
            sb.append(distance[u][v]).append("\n");
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
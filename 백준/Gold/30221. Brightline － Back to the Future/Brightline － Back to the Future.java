import java.util.ArrayList;
public class Main {

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static ArrayList<Edge> edges = new ArrayList<>();
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        for (int i = 0; i < m; i++) {
            int s = read();
            int e = read();
            int t = System.in.read();
            int a = read();
            if (t == 114) {
                a *= -1;
            }
            edges.add(new Edge(s, e, a));
        }
        bellmanFord();
    }

    public static void bellmanFord() {
        long[] dist = new long[n + 1];
        long max = Long.MAX_VALUE >> 3;
        for (int i = 0; i < n; i++) {
            dist[i] = max;
        }
        dist[1] = 0;
        boolean update = false;
        for (int i = 0; i < n - 1; i++) {
            update = false;
            for (int j = 0; j < m; j++) {
                Edge edge = edges.get(j);
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                if (dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                    update = true;
                }
            }
            if (!update) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] < 0) {
                sb.append(i).append("\n");
            }
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
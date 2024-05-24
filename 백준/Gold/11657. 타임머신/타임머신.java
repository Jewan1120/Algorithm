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
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        for (int i = 0; i < m; i++) {
            int u = read();
            int v = read();
            int w = read();
            edges.add(new Edge(u, v, w));
        }
        bellmanFord(n, m, 1);
    }
    
    private static void bellmanFord(int v, int e, int s) {
        long[] dist = new long[v + 1];
        long max = Long.MAX_VALUE;
        for (int i = 0; i <= v; i++) {
            dist[i] = max;
        }
        dist[s] = 0;
        boolean update = false;
        for(int i = 1; i < v; i++) {
            update = false;
            for (int j = 0; j < e; j++) {
                Edge edge = edges.get(j);
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                if (dist[src] != max && dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                    update = true;
                }
            }
            if (!update) break;
        }
        if (update) {
            for (int j = 0; j < e; j++) {
                Edge edge = edges.get(j);
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                if (dist[src] != max && dist[dest] > dist[src] + weight) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= v; i++) {
            sb.append(dist[i] == max ? -1 : dist[i]).append("\n");
        }
        System.out.println(sb);
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}
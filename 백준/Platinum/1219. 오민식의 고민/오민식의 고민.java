import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static ArrayList<Edge> edges;
    static long[] dist;
    static int N, A, B, M;
    static final long INF = Long.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        N = read();
        A = read();
        B = read();
        M = read();
        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = read(), v = read(), w = read();
            edges.add(new Edge(u, v, -w));
        }
        int[] earn = new int[N];
        for (int i = 0; i < N; i++)
            earn[i] = read();
        dist = new long[N];
        Arrays.fill(dist, INF);
        dist[A] = earn[A];
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != INF && dist[edge.v] < dist[edge.u] + edge.w + earn[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.w + earn[edge.v];
                }
            }
        }
        for (Edge edge : edges) {
            if (dist[edge.u] != INF && dist[edge.v] < dist[edge.u] + edge.w + earn[edge.v]) {
                if (isReachable(edge.v)) {
                    System.out.println("Gee");
                    return;
                }
            }
        }
        System.out.println(dist[B] == INF ? "gg" : dist[B]);
    }

    private static boolean isReachable(int start) {
        boolean[] visited = new boolean[N];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        visited[start] = true;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (cur == B)
                return true;
            for (Edge edge : edges) {
                if (edge.u == cur && !visited[edge.v]) {
                    dq.offer(edge.v);
                    visited[edge.v] = true;
                }
            }
        }
        return false;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static final int INF = Integer.MIN_VALUE;
    static ArrayList<Edge> edges;
    static int[] dist, trace;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new int[n + 1];
        trace = new int[n + 1];
        for(int i =0; i < n+1; i ++) {
            dist[i] = INF;
            trace[i] = -1;
        }
        dist[1] = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        boolean updated = false;
        for (int i = 0; i < n - 1; i++) {
            updated = false;
            for (Edge edge : edges) {
                if (dist[edge.u] != INF && dist[edge.v] < dist[edge.u] + edge.w) {
                    dist[edge.v] = dist[edge.u] + edge.w;
                    trace[edge.v] = edge.u;
                    updated = true;
                }
            }
            if (!updated)
                break;
        }
        if (dist[n] == INF) {
            System.out.println(-1);
            return;
        }
        for (Edge edge : edges) {
            if (dist[edge.u] != INF && dist[edge.v] < dist[edge.u] + edge.w) {
                if (isReachable(edge.v, n)) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = n;
        sb.append(n);
        while (trace[idx] != -1) {
          sb.insert(0, trace[idx] + " ");
          idx = trace[idx];
        }
        System.out.print(sb.toString());
    }

    private static boolean isReachable(int s, int n) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(s);
        visited[s] = true;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (cur == n)
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
}
import java.util.ArrayList;

public class Main {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Edge> edges;
    static int[] dist, trace;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), s = read();
        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            edges.add(new Edge(u, v, w));
        }
        dist = new int[n];
        trace = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            trace[i] = -1;
        }
        dist[s] = 0;
        boolean updated = false;
        for (int i = 0; i < n - 1; i++) {
            updated = false;
            for (Edge edge : edges) {
                if (dist[edge.u] != INF && dist[edge.v] > dist[edge.u] + edge.w) {
                    dist[edge.v] = dist[edge.u] + edge.w;
                    trace[edge.v] = edge.u;
                    updated = true;
                }
            }
            if (!updated)
                break;
        }
        if (updated)
            for (Edge edge : edges) {
                if (dist[edge.u] != INF && dist[edge.v] > dist[edge.u] + edge.w) {
                    printCycle(edge.v);
                    return;
                }
            }
        printPath(s);
    }

    private static void printCycle(int s) {
        StringBuilder sb = new StringBuilder();
        sb.append("CYCLE\n");
        boolean[] visited = new boolean[trace.length];
        int cur = s;
        while (!visited[cur]) {
            visited[cur] = true;
            cur = trace[cur];
        }
        ArrayList<Integer> cycle = new ArrayList<>();
        int cycleStart = cur;
        do {
            cycle.add(cur);
            cur = trace[cur];
        } while (cur != cycleStart);
        cycle.add(cycleStart);
        sb.append(cycle.size() - 1).append("\n");
        for (int i = cycle.size() - 1; i >= 0; i--) {
            sb.append(cycle.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static void printPath(int s) {
        StringBuilder sb = new StringBuilder();
        sb.append("PATH\n");
        for (int i = 0; i < dist.length; i++)
            sb.append(dist[i]).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}
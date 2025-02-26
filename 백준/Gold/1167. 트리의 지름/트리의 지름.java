import java.util.ArrayList;

public class Main {

    static class Edge {
        int t, w;

        Edge(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }

    static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
    static boolean[] visited;

    static int maxV = 0, maxLen = 0;

    public static void main(String[] args) throws Exception {
        int v = read();
        for (int i = 0; i < v + 1; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < v; i++) {
            int from = read();
            int to, dist;
            while ((to = read()) != -1) {
                dist = read();
                edges.get(from).add(new Edge(to, dist));
            }
        }
        visited = new boolean[v + 1];
        dfs(1, 0);
        visited = new boolean[v + 1];
        dfs(maxV, 0);
        System.out.println(maxLen);
    }

    private static void dfs(int cur, int len) {
        if (len > maxLen) {
            maxV = cur;
            maxLen = len;
        }
        visited[cur] = true;
        for (Edge edge : edges.get(cur))
            if (!visited[edge.t]) {
                dfs(edge.t, len + edge.w);
            }
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
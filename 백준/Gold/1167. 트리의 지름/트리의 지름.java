import java.util.ArrayList;
public class Main {
    
    static class Edge {
        int t;
        int w;

        public Edge(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }

    static ArrayList<ArrayList<Edge>> tree = new ArrayList<>();
    static boolean[] visited;
    static int mV;
    static int mL;

    public static void main(String[] args) throws Exception {
        int n = read();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = read();
            int v;
            while ((v = read()) != -1) {
                int w = read();
                tree.get(u).add(new Edge(v, w));
                tree.get(v).add(new Edge(u, w));
            }
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(mV, 0);
        System.out.println(mL);
    }

    private static void dfs(int s, int l) {
        if (l > mL) {
            mV = s;
            mL = l;
        }
        visited[s] = true;
        for (Edge edge : tree.get(s)) {
            if (!visited[edge.t]) {
                dfs(edge.t, l + edge.w);
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return m ? ~n + 1 : n;
    }
}
import java.util.ArrayList;

public class Main {

    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] depth;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        int n = read();
        for (int i = 0; i < n + 1; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = read(), u = read();
            adjList.get(v).add(u);
            adjList.get(u).add(v);
        }
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1];
        dfs(1, 0);
        StringBuilder sb = new StringBuilder();
        int m = read();
        while (m-- > 0) {
            int v = read(), u = read();
            sb.append(lca(v, u)).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int v, int d) {
        visited[v] = true;
        depth[v] = d;
        for (int u : adjList.get(v))
            if (!visited[u]) {
                parent[u] = v;
                dfs(u, d + 1);
            }
    }

    private static int lca(int v, int u) {
        while (depth[v] != depth[u])
            if (depth[v] > depth[u])
                v = parent[v];
            else
                u = parent[u];
        while (v != u) {
            v = parent[v];
            u = parent[u];
        }
        return v;
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
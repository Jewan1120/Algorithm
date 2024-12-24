import java.util.ArrayList;

public class Main {

    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int n, k = 0;
    static boolean[] visited;
    static int[] depth;
    static int[][] parent;

    public static void main(String[] args) throws Exception {
        n = read();
        k = (int) (Math.log(n) / Math.log(2)) + 1;
        for (int i = 0; i < n + 1; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = read(), u = read();
            adjList.get(v).add(u);
            adjList.get(u).add(v);
        }
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1][k];
        dfs(1, 0);
        fillParent();
        StringBuilder sb = new StringBuilder();
        int m = read();
        while (m-- > 0) {
            int v = read(), u = read();
            sb.append(lca(v, u)).append("\n");
        }
        System.out.println(sb);
    }

    private static void fillParent() {
        for (int i = 1; i < k; i++)
            for (int j = 1; j < n + 1; j++)
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
    }

    private static void dfs(int v, int d) {
        visited[v] = true;
        depth[v] = d;
        for (int u : adjList.get(v))
            if (!visited[u]) {
                parent[u][0] = v;
                dfs(u, d + 1);
            }
    }

    private static int lca(int v, int u) {
        if (depth[v] > depth[u]) {
            int temp = v;
            v = u;
            u = temp;
        }
        for (int i = k - 1; i >= 0; i--)
            if (depth[u] - depth[v] >= 1 << i)
                u = parent[u][i];
        if (v == u)
            return v;
        for (int i = k - 1; i >= 0; i--)
            if (parent[v][i] != parent[u][i]) {
                v = parent[v][i];
                u = parent[u][i];
            }

        return parent[v][0];
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
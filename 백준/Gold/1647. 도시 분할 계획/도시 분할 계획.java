import java.util.PriorityQueue;

public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        PriorityQueue<int[]> edges = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            edges.add(new int[] { u, v, w });
        }
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            parent[i] = i;
        int mstWeight = 0;
        int maxEdgeWeight = 0;
        int cnt = 0;
        while(cnt < n - 1) {
            int[] edge = edges.poll();
            if (union(edge[0], edge[1])) {
                mstWeight += edge[2];
                maxEdgeWeight = edge[2];
                cnt++;
            }
        }
        System.out.println(mstWeight - maxEdgeWeight);
    }

    private static int find(int v) {
        if (v != parent[v]) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private static boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
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
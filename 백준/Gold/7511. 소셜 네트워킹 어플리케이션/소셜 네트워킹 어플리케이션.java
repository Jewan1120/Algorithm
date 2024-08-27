public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        int tc = 0;
        while (tc++ < t) {
            int n = read();
            int k = read();
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
            for (int i = 0; i < k; i++)
                union(read(), read());
            int m = read();
            sb.append("Scenario ").append(tc).append(":\n");
            for (int i = 0; i < m; i++)
                if (find(read()) == find(read()))
                    sb.append("1\n");
                else
                    sb.append("0\n");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int v) {
        if (v != parent[v])
            parent[v] = find(parent[v]);
        return parent[v];
    }

    private static void union(int v, int u) {
        int rootV = find(v);
        int rootU = find(u);
        if (rootV != rootU)
            if (rank[rootV] < rank[rootU])
                parent[rootV] = rootU;
            else if (rank[rootV] > rank[rootU])
                parent[rootU] = rootV;
            else {
                parent[rootU] = rootV;
                rank[rootV]++;
            }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
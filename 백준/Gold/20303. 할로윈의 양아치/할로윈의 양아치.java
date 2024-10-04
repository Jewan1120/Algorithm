public class Main {

    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), k = read();
        int[] candy = new int[n + 1];
        int[] cnt = new int[n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            candy[i] = read();
            parent[i] = i;
            cnt[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            int x = read(), y = read();
            union(x, y);
        }
        int len = 0;
        for (int i = 1; i < n + 1; i++) {
            if (parent[i] != i) {
                int root = find(i);
                candy[root] += candy[i];
                cnt[root]++;
            } else
                len++;
        }
        int[][] group = new int[len][2];
        int idx = 0;
        for (int i = 1; i < n + 1; i++)
            if (parent[i] == i)
                group[idx++] = new int[] { cnt[i], candy[i] };
        int[] dp = new int[k];
        for (int i = 0; i < len; i++)
            for (int j = k - 1; j >= group[i][0]; j--)
                dp[j] = Math.max(dp[j], dp[j - group[i][0]] + group[i][1]);
        System.out.println(dp[k - 1]);
    }

    private static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

        }
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
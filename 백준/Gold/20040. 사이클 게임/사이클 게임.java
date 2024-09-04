public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 1; i <= m; i++) {
            int x = read(), y = read();
            if (find(x) == find(y)) {
                System.out.println(i);
                return;
            }
            union(x, y);
        }
        System.out.println(0);
    }

    private static int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY)
            parent[rootX] = rootY;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
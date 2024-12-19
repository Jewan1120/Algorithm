import java.util.HashSet;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (true) {
            int n = read(), m = read();
            if (n == 0 && m == 0)
                break;
            parent = new int[n + 1];
            for (int i = 0; i < n + 1; i++)
                parent[i] = i;
            boolean[] isCycle = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                int x = read(), y = read();
                int rootX = find(x), rootY = find(y);
                if (rootX == rootY)
                    isCycle[rootX] = true;
                parent[rootX] = rootY;
                isCycle[rootY] |= isCycle[rootX];
            }
            HashSet<Integer> roots = new HashSet<>();
            for (int i = 1; i < n + 1; i++) {
                int root = find(i);
                if (!isCycle[root])
                    roots.add(root);
            }
            sb.append("Case ").append(++idx).append(": ");
            if (roots.size() == 0)
                sb.append("No trees.\n");
            else if (roots.size() == 1)
                sb.append("There is one tree.\n");
            else
                sb.append("A forest of ").append(roots.size()).append(" trees.\n");
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (x == parent[x])
            return parent[x];
        return parent[x] = find(parent[x]);
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
import java.util.ArrayList;

public class Main {

    static int v, e;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] groups;

    public static void main(String[] args) throws Exception {
        int k = read();
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            init();
            boolean isBipartite = true;
            for (int i = 1; i < v + 1; i++)
                if (groups[i] == 0)
                    if (!dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
            sb.append(isBipartite ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }

    private static boolean dfs(int node, int group) {
        groups[node] = group;
        for (int next : edges.get(node))
            if (groups[next] == 0) {
                if (!dfs(next, 3 - group))
                    return false;

            } else if (groups[next] == group)
                return false;
        return true;
    }

    private static void init() throws Exception {
        v = read();
        e = read();
        groups = new int[v + 1];
        edges = new ArrayList<>();
        for (int i = 0; i < v + 1; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < e; i++) {
            int v = read(), u = read();
            edges.get(v).add(u);
            edges.get(u).add(v);
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
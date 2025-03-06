import java.util.ArrayList;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static ArrayList<ArrayList<int[]>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read(), m = read();
            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++)
                graph.add(new ArrayList<>());
            visited = new boolean[n + 1];
            int u, v, d;
            for (int i = 0; i < m; i++) {
                u = read();
                v = read();
                d = read();
                graph.get(u).add(new int[] { v, d });
                graph.get(v).add(new int[] { u, d });
            }
            int minValue = recursive(new int[] { 1, INF });
            if (minValue == INF)
                minValue = 0;
            sb.append(minValue).append("\n");
        }
        System.out.println(sb);
    }

    private static int recursive(int[] u) {
        visited[u[0]] = true;
        int minD = 0;
        for (int[] v : graph.get(u[0]))
            if (!visited[v[0]])
                minD += recursive(v);
        return Math.min(minD == 0 ? INF : minD, u[1]);
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
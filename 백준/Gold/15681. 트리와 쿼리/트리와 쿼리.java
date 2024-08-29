import java.util.ArrayList;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] size;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        int n = read(), r = read(), q = read();
        size = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = read(), v = read();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        countSubtreeNodes(r);
        StringBuilder sb = new StringBuilder();
        while (q-- > 0)
            sb.append(size[read()]).append("\n");
        System.out.println(sb);
    }

    private static void countSubtreeNodes(int u) {
        visited[u] = true;
        size[u] = 1;
        for (int v : graph.get(u)) {
            if (visited[v])
                continue;
            countSubtreeNodes(v);
            size[u] += size[v];
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.ArrayList;

public class Main {

    static int n;
    static ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
    static boolean[] visited;
    static int maxNode = 0, maxWeight = 0;

    public static void main(String[] args) throws Exception {
        n = read();
        for (int i = 0; i < n + 1; i++)
            tree.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = read(), v = read(), w = read();
            tree.get(u).add(new int[] { v, w });
            tree.get(v).add(new int[] { u, w });
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(maxNode, 0);
        System.out.println(maxWeight);
    }

    private static void dfs(int node, int weight) {
        if (weight > maxWeight) {
            maxNode = node;
            maxWeight = weight;
        }
        visited[node] = true;
        for (int[] edge : tree.get(node)) {
            if (visited[edge[0]])
                continue;
            dfs(edge[0], weight + edge[1]);
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
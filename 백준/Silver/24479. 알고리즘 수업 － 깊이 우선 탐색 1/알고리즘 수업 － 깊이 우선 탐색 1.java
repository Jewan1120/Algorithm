import java.util.ArrayList;

public class Main {

    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int order = 1;

    public static void main(String[] args) throws Exception {
        n = read();
        int m = read(), r = read();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 0; i < n + 1; i++)
            graph.get(i).sort((o1, o2) -> o1 - o2);
        visited = new int[n + 1];
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++)
            sb.append(visited[i]).append("\n");
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = order++;
        for (int next : graph.get(cur)) {
            if (visited[next] == 0)
                dfs(next);
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
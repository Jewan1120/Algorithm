import java.util.ArrayList;

public class Main {

    static int n, m;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean flg = true;
        for (int i = 1; i <= n; i++)
            if (visited[i] == 0)
                if (!dfs(i, 1)) {
                    flg = false;
                    break;
                }
        if (flg)
            System.out.println(cnt * (n - cnt) * 2);
        else
            System.out.println(0);
    }

    private static boolean dfs(int u, int c) {
        visited[u] = c;
        if (c == 1) {
            cnt++;
        }

        for (int v : graph.get(u)) {
            if (visited[v] == 0) {
                if (!dfs(v, c == 1 ? 2 : 1))
                    return false;
            } else if (visited[v] == c) {
                return false;
            }
        }
        return true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
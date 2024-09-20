import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int q = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = read(), v = read();
            graph.get(u).add(v);
            graph.get(v).add(u);
            int[] visited = new int[n + 1];
            Arrays.fill(visited, -1);
            Deque<Integer> dq = new ArrayDeque<>();
            dq.offer(1);
            int depth = 0;
            while (!dq.isEmpty()) {
                int t = dq.size();
                while (t-- > 0) {
                    int cur = dq.poll();
                    if (visited[cur] != -1)
                        continue;
                    visited[cur] = depth;
                    for (int next : graph.get(cur))
                        dq.offer(next);
                }
                depth++;
            }
            for (int j = 1; j < n + 1; j++) {
                sb.append(visited[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] result = new int[n + 1];
        int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int s = read(), e = read();
            graph.get(s).add(e);
            indegree[e]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            if (indegree[i] == 0) {
                dq.offer(i);
                result[i] = 1;
            }
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    dq.offer(v);
                    result[v] = result[u] + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(result[i]).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        int[] indegree = new int[n + 1];
        int[] adjacency = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int j;
            while ((j = read()) != 0) {
                graph.get(i).add(j);
                indegree[j]++;
                adjacency[j]++;
            }
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int m = read();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        for (int i = 0; i < m; i++) {
            dq.offer(read());
        }
        int depth = 0;
        while (!dq.isEmpty()) {
            int t = dq.size();
            while (t-- > 0) {
                int u = dq.poll();
                if (visited[u] != -1)
                    continue;
                visited[u] = depth;
                for (int v : graph.get(u)) {
                    indegree[v]--;
                    if (indegree[v] == adjacency[v] - Math.ceil(adjacency[v] / 2.0))
                        dq.offer(v);
                }
            }
            depth++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++)
            sb.append(visited[i]).append(" ");
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
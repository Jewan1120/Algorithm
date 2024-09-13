import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 1; i < n + 1; i++) {
            int u = read(), v = read();
            indegree[u]++;
            indegree[v]++;
            graph.get(i).add(u);
            graph.get(i).add(v);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++)
            if (indegree[i] < 2)
                dq.offer(i);
        boolean[] visited = new boolean[n + 1];
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (visited[cur])
                continue;
            visited[cur] = true;
            for (int v : graph.get(cur)) {
                indegree[v]--;
                if (indegree[v] < 2)
                    dq.offer(v);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i < n + 1; i++)
            if (indegree[i] == 2) {
                cnt++;
                sb.append(i).append(" ");
            }
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
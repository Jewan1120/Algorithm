import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read(), k = read(), x = read();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++)
            graph.get(read()).add(read());

        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> dist[v1] - dist[v2]);
        pq.offer(x);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (visited[u])
                continue;
            visited[u] = true;
            for (int v : graph.get(u)) {
                if (!visited[v] && dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    pq.offer(v);
                }
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            if (dist[i] == k)
                al.add(i);
        if (al.size() == 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i : al)
                sb.append(i).append("\n");
            System.out.println(sb);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
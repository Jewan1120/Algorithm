import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++)
            graph.get(read()).add(new int[] { read(), read() });
        int s = read(), e = read();
        int[][] dist = new int[n + 1][1];
        for (int i = 0; i < n + 1; i++)
            dist[i] = new int[] { Integer.MAX_VALUE, i };
        dist[s][0] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1][0] - dist[o2][0]);
        boolean[] visited = new boolean[n + 1];
        pq.offer(s);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (visited[u])
                continue;
            visited[u] = true;
            for (int[] v : graph.get(u)) {
                if (dist[u][0] + v[1] < dist[v[0]][0]) {
                    dist[v[0]][0] = dist[u][0] + v[1];
                    dist[v[0]][1] = u;
                    pq.offer(v[0]);
                }
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] path = new boolean[n + 1];
        int idx = e;
        al.add(e);
        while (idx != s) {
            path[idx] = true;
            al.add(dist[idx][1]);
            idx = dist[idx][1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dist[e][0]).append("\n");
        sb.append(al.size()).append("\n");
        for (int i = al.size() - 1; i >= 0; i--)
            sb.append(al.get(i)).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
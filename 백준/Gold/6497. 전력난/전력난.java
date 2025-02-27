import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static int m, n;
    static ArrayList<ArrayList<int[]>> edges;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            m = read();
            n = read();
            edges = new ArrayList<>();
            if (m == 0 && n == 0)
                break;
            for (int i = 0; i < m; i++)
                edges.add(new ArrayList<>());
            int u, v, w;
            int cost = 0;
            for (int i = 0; i < n; i++) {
                u = read();
                v = read();
                w = read();
                cost += w;
                edges.get(u).add(new int[] { v, w });
                edges.get(v).add(new int[] { u, w });
            }
            boolean[] visited = new boolean[m];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            pq.offer(new int[] { 0, 0 });
            int cnt = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (visited[cur[0]])
                    continue;
                cost -= cur[1];
                cnt++;
                if (cnt == n - 1)
                    break;
                visited[cur[0]] = true;
                for (int[] next : edges.get(cur[0])) {
                    if (!visited[next[0]]) {
                        pq.offer(next);
                    }
                }
            }
            sb.append(cost).append("\n");
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
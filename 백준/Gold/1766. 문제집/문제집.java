import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = read(), v = read();
            graph.get(u).add(v);
            indegree[v]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < n + 1; i++)
            if (indegree[i] == 0)
                pq.offer(i);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for (int v : graph.get(cur)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    pq.offer(v);
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
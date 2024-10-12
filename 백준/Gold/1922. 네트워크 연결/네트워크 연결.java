import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        boolean[] visited = new boolean[n + 1];
        pq.offer(new Edge(1, 0));
        int minWeight = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.v])
                continue;
            minWeight += cur.w;
            visited[cur.v] = true;
            for (Edge edge : graph.get(cur.v))
                if (!visited[edge.v]) {
                    pq.offer(edge);
                }
        }
        System.out.println(minWeight);
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
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
        int n = read();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 1; i < n + 1; i++) {
            graph.get(0).add(new Edge(i, read()));
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int w = read();
                if (w == 0)
                    continue;
                graph.get(i).add(new Edge(j, w));
            }
        }
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        for (Edge edge : graph.get(0))
            pq.offer(edge);
        visited[0] = true;
        int sumWeight = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.v])
                continue;
            visited[cur.v] = true;
            sumWeight += cur.w;
            for (Edge edge : graph.get(cur.v)) {
                if (!visited[edge.v]) {
                    pq.offer(edge);
                }
            }
        }
        System.out.println(sumWeight);
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
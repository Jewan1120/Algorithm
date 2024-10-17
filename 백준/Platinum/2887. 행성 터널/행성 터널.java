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
        ArrayList<int[]> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = read(), y = read(), z = read();
            graph.add(new int[] { i, x, y, z });
        }
        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++)
            edges.add(new ArrayList<>());
        for (int i = 1; i < 4; i++) {
            int idx = i;
            graph.sort((o1, o2) -> o1[idx] - o2[idx]);
            for (int j = 0; j < n - 1; j++) {
                int u = graph.get(j)[0];
                int v = graph.get(j + 1)[0];
                int w = Math.abs(graph.get(j)[idx] - graph.get(j + 1)[idx]);
                edges.get(u).add(new Edge(v, w));
                edges.get(v).add(new Edge(u, w));
            }
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        boolean[] visited = new boolean[n];
        pq.offer(new Edge(0, 0));
        int sumWeight = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.v])
                continue;
            visited[cur.v] = true;
            sumWeight += cur.w;
            for (Edge edge : edges.get(cur.v)) {
                if (!visited[edge.v])
                    pq.offer(edge);
            }
        }
        System.out.println(sumWeight);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}
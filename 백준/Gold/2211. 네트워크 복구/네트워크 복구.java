import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static class Node {
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = read(), v = read(), w = read();
            graph.get(u).add(new Node(u, v, w));
            graph.get(v).add(new Node(v, u, w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        boolean[] visited = new boolean[n + 1];
        pq.offer(new Node(1, 1, 0));
        visited[1] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(n - 1).append("\n");
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            if (!visited[u.to]) {
                visited[u.to] = true;
                sb.append(u.from).append(" ").append(u.to).append("\n");
            }
            for (Node v : graph.get(u.to)) {
                if (dist[v.to] > dist[u.to] + v.weight) {
                    dist[v.to] = dist[u.to] + v.weight;
                    pq.offer(new Node(v.from, v.to, dist[v.to]));
                }
            }
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
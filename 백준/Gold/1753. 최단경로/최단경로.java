import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {

        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(u, w));
        }
        dist[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int v = cur.to;
            int w = cur.weight;
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            for (Node node : graph.get(v)) {
                if (dist[node.to] > node.weight + w) {
                    dist[node.to] = node.weight + w;
                    pq.offer(new Node(node.to, node.weight + w));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF").append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
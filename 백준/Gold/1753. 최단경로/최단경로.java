import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(u, w));
        }
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        visited[s] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> dist[v1] - dist[v2]);
        pq.offer(s);
        while (!pq.isEmpty()) {
            int v = pq.poll();
            for (Node node : graph.get(v)) {
                int u = node.to;
                int w = node.weight;
                if (dist[u] > dist[v] + w) {
                    dist[u] = dist[v] + w;
                    pq.offer(u);
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
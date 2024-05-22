import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static class Edge {
        int t;
        int w;
        
        public Edge(int t, int w){
            this.t = t;
            this.w = w;
        }
    }
    
    static int n;
    static int m;
    static int x;
    static ArrayList<Edge>[] to, from;
    
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        x = read();
        to = new ArrayList[n + 1];
        from = new ArrayList[n + 1];
        int max = 0;
        for (int i = 0; i <= n; i++) {
            to[i] = new ArrayList<>();
            from[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = read();
            int v = read();
            int w = read();
            to[u].add(new Edge(v, w));
            from[v].add(new Edge(u, w));
        }
        int[] distTo = find(to, x);
        int[] distFrom = find(from, x);
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distTo[i] + distFrom[i]);
        }
        System.out.println(max);
    }
    
    private static int[] find(ArrayList<Edge>[] graph, int s) {
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(dist[v1], dist[v2]));
        pq.offer(s);
        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (visited[u]) continue;
            visited[u] = true;
            for (Edge edge : graph[u]) {
                int v = edge.t;
                int w = edge.w;
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(v);
                }
            }
        }
        return dist;
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int to;
        double distance;

        Edge(int to, double distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                double distance = calDistance(stars[i], stars[j]);
                graph.get(i).add(new Edge(j, distance));
                graph.get(j).add(new Edge(i, distance));
            }
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.distance, o2.distance));
        pq.offer(new Edge(0, 0));
        double mstDistance = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.to;
            if (visited[u])
                continue;
            visited[u] = true;
            if(cnt == n)
                break;
            cnt++;
            mstDistance += cur.distance;
            for (Edge next : graph.get(u)) {
                int v = next.to;
                if (!visited[v])
                    pq.offer(next);
            }
        }
        System.out.println(mstDistance);
    }

    private static double calDistance(double[] A, double[] B) {
        return Math.abs(Math.sqrt(Math.pow(B[0] - A[0], 2) + Math.pow(B[1] - A[1], 2)));
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 0
public class Main {

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int N;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();
    static List<Edge> newEdges = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int alreadyConnectedCost = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());

                if (i < j) {
                    if (cost < 0) {
                        alreadyConnectedCost += -cost;
                        union(i, j);
                    } else {
                        edges.add(new Edge(i, j, cost));
                    }
                }
            }
        }

        Collections.sort(edges);

        int newRailwaysCount = 0;
        int newRailwaysCost = 0;
        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                newRailwaysCount++;
                newRailwaysCost += edge.weight;
                newEdges.add(edge);
            }
        }

        totalCost = alreadyConnectedCost + newRailwaysCost;

        StringBuilder sb = new StringBuilder();
        sb.append(totalCost).append(" ").append(newRailwaysCount).append("\n");
        for (Edge edge : newEdges) {
            sb.append(edge.u).append(" ").append(edge.v).append("\n");
        }
        System.out.println(sb);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
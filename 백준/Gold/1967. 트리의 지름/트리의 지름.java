import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int t;
        int w;

        public Node(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }

    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static boolean[] visited;
    static int maxNode;
    static int maxWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree.get(v).add(new Node(u, w));
            tree.get(u).add(new Node(v, w));
        }
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(maxNode, 0);
        System.out.println(maxWeight);
    }

    public static void dfs(int node, int weight) {
        if (weight > maxWeight) {
            maxWeight = weight;
            maxNode = node;
        }
        visited[node] = true;
        for (Node next : tree.get(node)) {
            if (!visited[next.t]) {
                dfs(next.t, weight + next.w);
            }
        }
    }
}
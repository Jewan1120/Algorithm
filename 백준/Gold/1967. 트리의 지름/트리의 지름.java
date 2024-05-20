import java.util.ArrayList;

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

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int v = in.nextInt();
            int u = in.nextInt();;
            int w = in.nextInt();
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

    static class Reader {

        private final int SIZE = 1 << 13;

        private byte[] buffer = new byte[SIZE];
        private int index;
        private int size;

        private int n;
        private byte c;

        public int nextInt() throws Exception {
            n = 0;
            while ((c = read()) <= 32);
            do
                n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return n;
        }

        private boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        private byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0)
                    buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    static int n;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] populations;
    static boolean[] groups;
    static int totalPopulation = 0, minDiff = Integer.MAX_VALUE;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        n = read();
        populations = new int[n + 1];
        groups = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            populations[i] = read();
            totalPopulation += populations[i];
        }
        edges.add(new ArrayList<>());
        for (int i = 1; i < n + 1; i++) {
            int m = read();
            edges.add(new ArrayList<>());
            for (int j = 0; j < m; j++)
                edges.get(i).add(read());
        }
        recursive(1, 0, 0);
        System.out.println(minDiff != Integer.MAX_VALUE ? minDiff : -1);
    }

    private static void recursive(int depth, int cnt, int sumPopluation) {
        if (depth == n) {
            if (cnt == 0 || cnt == n)
                return;
            if (isPossible()) {
                int diff = Math.abs(totalPopulation - (sumPopluation * 2));
                minDiff = Math.min(minDiff, diff);
            }
            return;
        }
        groups[depth] = true;
        recursive(depth + 1, cnt + 1, sumPopluation + populations[depth]);
        groups[depth] = false;
        recursive(depth + 1, cnt, sumPopluation);
    }

    private static boolean isPossible() {
        for (int i = 1; i < n + 1; i++)
            parent[i] = i;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i < n + 1; i++)
            for (int j : edges.get(i))
                if (groups[i] == groups[j])
                    union(i, j);
        for (int i = 1; i < n + 1; i++)
            hs.add(find(i));
        return hs.size() == 2;
    }

    private static int find(int x) {
        if (parent[x] == x)
            return parent[x];
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY)
            parent[rootY] = rootX;
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
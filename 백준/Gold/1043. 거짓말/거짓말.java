import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        Set<Integer> knowPeople = new HashSet<>();
        int kp = read();
        while (kp-- > 0) {
            int knowPerson = read();
            knowPeople.add(knowPerson);
            parent[knowPerson] = 0;
        }
        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            int p = read();
            parties[i] = new int[p];
            int firstPeople = read();
            parties[i][0] = firstPeople;
            for (int j = 1; j < p; j++) {
                int nextPerson = read();
                parties[i][j] = nextPerson;
                union(firstPeople, nextPerson);
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (find(parties[i][0]) != 0)
                cnt++;
        }
        System.out.println(cnt);
    }

    private static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            int max = Math.max(rootX, rootY);
            int min = Math.min(rootX, rootY);
            parent[max] = min;

        }
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
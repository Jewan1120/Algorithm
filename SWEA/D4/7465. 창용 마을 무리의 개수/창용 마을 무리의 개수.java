import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static int[] parent, rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n, m, u, v;
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i < n + 1; i++)
                parent[i] = i;
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                union(u, v);
            }
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 1; i < n + 1; i++)
                hs.add(find(i));
            sb.append("#").append(tc).append(" ").append(hs.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parent[x] == x)
            return parent[x];
        return parent[x] = find(parent[x]);
    }

    private static void union(int y, int x) {
        int rootY = find(y), rootX = find(x);
        if (rootY == rootX)
            return;
        if (rank[rootY] < rank[rootX])
            parent[rootY] = rootX;
        else if (rank[rootY] > rank[rootX])
            parent[rootX] = rootY;
        else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }
}

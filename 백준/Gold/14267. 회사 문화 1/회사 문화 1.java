import java.util.ArrayList;

public class Main {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] score;

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }
        read();
        for (int i = 1; i < n; i++)
            tree.get(read()).add(i + 1);
        score = new int[n + 1];
        for (int i = 0; i < m; i++) {
            score[read()] += read();
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(score[i]).append(" ");
        System.out.println(sb);
    }

    private static void dfs(int parent) {
        for (int child : tree.get(parent)) {
            score[child] += score[parent];
            dfs(child);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        n = read();
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
            int parent = read();
            if (parent == -1)
                continue;
            tree.get(parent).add(i);
        }
        recursive(0);
        System.out.println(dp[0]);
    }

    private static void recursive(int cur) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int next : tree.get(cur)) {
            recursive(next);
            pq.offer(dp[next]);
        }
        int time = 1;
        while(!pq.isEmpty())
            dp[cur] = Math.max(dp[cur], pq.poll() + time++);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(n);
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (cur == 1) {
                System.out.println(dp[cur]);
                return;
            }
            if (cur % 3 == 0 && dp[cur / 3] == 0) {
                dp[cur / 3] = dp[cur] + 1;
                dq.offer(cur / 3);
            }
            if (cur % 2 == 0 && dp[cur / 2] == 0) {
                dp[cur / 2] = dp[cur] + 1;
                dq.offer(cur / 2);
            }
            if (dp[cur - 1] == 0) {
                dp[cur - 1] = dp[cur] + 1;
                dq.offer(cur - 1);
            }
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
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[100_001];
        dq.offer(new int[] { n, 0 });
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] < 0 || cur[0] > 100_000 || visited[cur[0]])
                continue;
            visited[cur[0]] = true;
            if (cur[0] == k) {
                System.out.println(cur[1]);
                return;
            }
            dq.offer(new int[] { cur[0] - 1, cur[1] + 1 });
            dq.offer(new int[] { cur[0] + 1, cur[1] + 1 });
            dq.offer(new int[] { cur[0] * 2, cur[1] + 1 });
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
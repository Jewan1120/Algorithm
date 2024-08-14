import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] visited = new int[100_001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { n, 0 });
        int min = Integer.MAX_VALUE, cnt = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] < 0 || cur[0] > 100_000)
                continue;
            if (cur[0] == k) {
                if (min == cur[1])
                    cnt++;
                else if (min > cur[1]) {
                    cnt = 1;
                    min = cur[1];
                }
                continue;
            }
            if (visited[cur[0]] < cur[1] || min < cur[1])
                continue;
            visited[cur[0]] = cur[1];
            dq.offer(new int[] { cur[0] - 1, cur[1] + 1 });
            dq.offer(new int[] { cur[0] + 1, cur[1] + 1 });
            dq.offer(new int[] { cur[0] * 2, cur[1] + 1 });
        }
        System.out.println(min);
        System.out.println(cnt);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
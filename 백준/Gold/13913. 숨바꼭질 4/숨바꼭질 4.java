import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[][] visited = new int[100_001][2];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, n, 0 });
        Arrays.fill(visited, new int[] { 0, Integer.MAX_VALUE });
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[1] < 0 || cur[1] > 100_000 || visited[cur[1]][1] <= cur[2])
                continue;
            visited[cur[1]] = new int[] { cur[0], cur[2] };
            if (cur[1] == k) {
                StringBuilder sb = new StringBuilder();
                for (int i = cur[1]; i != n; i = visited[i][0]) {
                    sb.insert(0, " ").insert(0, i);
                }
                sb.insert(0, " ").insert(0, n);
                System.out.println(cur[2]);
                System.out.println(sb);
                return;
            }
            dq.offer(new int[] { cur[1], cur[1] - 1, cur[2] + 1 });
            dq.offer(new int[] { cur[1], cur[1] + 1, cur[2] + 1 });
            dq.offer(new int[] { cur[1], cur[1] * 2, cur[2] + 1 });
        }
        System.out.println();
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int time = 0;
        boolean[][] visited = new boolean[500_001][2];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(n);
        while ((k += time) <= 500_000) {
            int size = dq.size();
            while (size-- > 0) {
                int cur = dq.poll();
                if (cur < 0 || cur > 500_000 || visited[cur][time % 2])
                    continue;
                visited[cur][time % 2] = true;
                dq.offer(cur - 1);
                dq.offer(cur + 1);
                dq.offer(cur * 2);
            }
            if (visited[k][time % 2]) {
                System.out.println(time);
                return;
            }
            time++;
        }
        System.out.println(-1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int max = 100_001;
        boolean[] visited = new boolean[max];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(n);
        dq.offer(0);
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            int cnt = dq.poll();
            visited[cur] = true;
            if (cur == k) {
                min = Math.min(min, cnt);
            }
            if (cur + 1 < max && !visited[cur + 1]) {
                dq.offer(cur + 1);
                dq.offer(cnt + 1);
            }
            if (cur > 0 && !visited[cur - 1]) {
                dq.offer(cur - 1);
                dq.offer(cnt + 1);
            }
            if (cur * 2 < max && !visited[cur * 2]) {
                dq.offer(cur * 2);
                dq.offer(cnt);
            }
        }
        System.out.println(min);
        br.close();
    }
}
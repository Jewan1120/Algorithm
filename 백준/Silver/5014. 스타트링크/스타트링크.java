import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[f + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(s);
        dq.offer(0);
        visited[s] = true;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            int cnt = dq.poll();
            if (cur == g) {
                System.out.println(cnt);
                return;
            }
            int uf = cur + u;
            if (uf <= f && !visited[uf]) {
                dq.offer(uf);
                dq.offer(cnt + 1);
                visited[uf] = true;
            }
            int df = cur - d;
            if (0 < df && !visited[df]) {
                dq.offer(df);
                dq.offer(cnt + 1);
                visited[df] = true;
            }
        }
        System.out.println("use the stairs");
    }
}
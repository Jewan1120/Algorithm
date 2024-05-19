import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        next: for (; t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            int[][] p = new int[n + 2][2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                p[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }
            boolean[][] dist = new boolean[n + 2][n + 2];
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if (i != j) {
                        int d = Math.abs(p[i][0] - p[j][0]) + Math.abs(p[i][1] - p[j][1]);
                        if (d <= 1000) {
                            dist[i][j] = true;
                        }
                    }
                }
            }
            boolean[] visited = new boolean[n + 2];
            Deque<Integer> dq = new ArrayDeque<>();
            dq.offer(0);
            visited[0] = true;
            while (!dq.isEmpty()) {
                int cur = dq.poll();
                if (cur == n + 1) {
                    System.out.println("happy");
                    continue next;
                }
                for (int i = 0; i < n + 2; i++) {
                    if (dist[cur][i] && !visited[i]) {
                        dq.offer(i);
                        visited[i] = true;
                    }
                }
            }
            System.out.println("sad");
        }
    }
}
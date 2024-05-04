import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] board = new int[101];
        boolean[] visited = new boolean[101];
        for (int i = 0; i < 101; i++) {
            board[i] = i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            board[n] = m;
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {1, 0});
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == 100) {
                System.out.println(cur[1]);
                break;
            }
            for (int i = 1; i < 7; i++) {
                int p = board[cur[0]]+ i;
                if (p <= 100) {
                    if (!visited[p]) {
                        dq.add(new int[] {p, cur[1] + 1});
                        visited[p] = true;
                    }
                }
            }
        }
        br.close();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                hs.add(k);
                board[i][j] = k;
            }
        }
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
        int max = 1;
        for (int p : hs) {
            boolean[][] visited = new boolean[n][n];
            Deque<int[]> dq = new ArrayDeque<>();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] > p && !visited[i][j]) {
                        cnt++;
                        dq.offer(new int[] {i, j});
                        visited[i][j] = true;
                        while (!dq.isEmpty()) {
                            int[] cur = dq.poll();
                            for (int k = 0; k < 4; k++) {
                                int y = cur[0] + dy[k];
                                int x = cur[1] + dx[k];
                                if (0 <= y && y < n && 0 <= x && x < n) {
                                    if (board[y][x] > p && !visited[y][x]) {
                                        dq.offer(new int[] {y, x});
                                        visited[y][x] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
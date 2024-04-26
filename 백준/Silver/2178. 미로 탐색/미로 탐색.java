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
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0, 0});
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1)
                break;
            int v = board[cur[0]][cur[1]];
            board[cur[0]][cur[1]] = 0;
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (0 <= y && y < n && 0 <= x && x < m) {
                    if (board[y][x] == 1) {
                        board[y][x] = v + 1;
                        dq.add(new int[] {y, x});
                    }
                }
            }
        }
        System.out.println(board[n - 1][m - 1]);
    }
}
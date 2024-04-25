import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };
        int[][] board = new int[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int p = Integer.parseInt(st.nextToken());
                if (p == 1) {
                    board[i][j] = -1;
                }
                if (p == 2) {
                    board[i][j] = 0;
                    dq.add(new int[] { i, j });
                }
            }
        }
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int d = board[cur[0]][cur[1]];
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (0 <= y && y < n && 0 <= x && x < m) {
                    if (board[y][x] == -1) {
                        board[y][x] = d + 1;
                        dq.add(new int[] { y, x });
                    }
                } 
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]).append(" ");
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
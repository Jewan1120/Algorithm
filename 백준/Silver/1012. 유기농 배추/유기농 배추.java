import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (; n > 0; n--) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] board = new int[h][w];
            for (; k > 0; k--) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y][x]++;
            }
            int cnt = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (board[y][x] == 1) {
                        cnt++;
                        bfs(board, new int[]{ y, x });
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs(int[][] board, int[] p) {
        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };
        int h = board.length;
        int w = board[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(p);
        board[p[0]][p[1]]--;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (0 <= y && y < h && 0 <= x && x < w) {
                    if (board[y][x] == 1) {
                        dq.add(new int[]{ y, x });
                        board[y][x]--;
                    }
                }
            }
        }
    }
}
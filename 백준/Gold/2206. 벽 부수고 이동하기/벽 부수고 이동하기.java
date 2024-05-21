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
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] board = new int[h][w];
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        boolean[][][] visited = new boolean[h][w][2];
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0, 1, 1});
        visited[0][0][1] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cnt = cur[2];
            int breach = cur[3];
            if (cur[0] == h - 1 && cur[1] == w - 1) {
                System.out.println(cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (0 <= y && y < h && 0 <= x && x < w && !visited[y][x][breach]) {
                    if (board[y][x] == 0) {
                        dq.offer(new int[] {y, x, cnt + 1, breach});
                        visited[y][x][breach] = true;
                    } else if (breach == 1) {
                        dq.offer(new int[] {y, x, cnt + 1, 0});
                        visited[y][x][0] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
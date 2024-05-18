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
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] board = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
        Deque<int[]> dq = new ArrayDeque<>();
        int year = 0;
        while (true) {
            int cnt = 0;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] > 0 && !visited[i][j]) {
                        cnt++;
                        if (cnt >= 2) {
                            System.out.println(year);
                            return;
                        }
                        dq.offer(new int[] {i, j});
                        visited[i][j] = true;
                        while (!dq.isEmpty()) {
                            int[] p = dq.poll();
                            for (int k = 0; k < 4; k++) {
                                int y = p[0] + dy[k];
                                int x = p[1] + dx[k];
                                if (0 <= y && y < h && 0 <= x && x < w) {
                                    if (!visited[y][x]) {
                                        if (board[y][x] > 0) {
                                            dq.offer(new int[] {y, x});
                                            visited[y][x] = true;
                                        } else {
                                            board[p[0]][p[1]]--;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (cnt == 0) {
                System.out.println(0);
                return;
            }
            year++;
        }
    }
}
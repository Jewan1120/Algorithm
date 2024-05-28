import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        n = read();
        visited = new boolean[n][n];
        board = new int[n][n];
        int no = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = read();
            }
        }
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0 && !visited[i][j]) {
                    dq.offer(new int[] {i, j, ++no});
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        int y = cur[0], x = cur[1], in = cur[2];
                        if (visited[y][x]) continue;
                        visited[y][x] = true;
                        board[y][x] = in;
                        for (int k = 0; k < 4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if (isValid(ny, nx) && board[ny][nx] != 0 && !visited[ny][nx]){
                                dq.offer(new int[] {ny, nx, in});
                            }
                        }
                    }
                }
            }
        }
        int min = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] <= 0) continue;
                no = board[i][j];
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (isValid(ny, nx) && board[ny][nx] == 0) {
                        board[ny][nx] = -1; // 경계 체크
                        visited = new boolean[n][n];
                        dq = new ArrayDeque<>();
                        dq.offer(new int[] {ny, nx, 1});
                        loop: while(!dq.isEmpty()) {
                            int[] cur = dq.poll();
                            int y = cur[0], x = cur[1], cnt = cur[2];
                            if (cnt > min || visited[y][x]) continue;
                            visited[y][x] = true;
                            for (int l = 0; l < 4; l++) {
                                int my = y + dy[l];
                                int mx = x + dx[l];
                                if (isValid(my, mx)) {
                                    if (board[my][mx] == 0) {
                                        dq.offer(new int[] {my, mx, cnt + 1});
                                    } else if (board[my][mx] > 0 && board[my][mx] != no) {
                                        min = Math.min(min, cnt);
                                        break loop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
    
    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
    
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
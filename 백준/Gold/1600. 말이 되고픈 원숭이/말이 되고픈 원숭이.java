import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
public class Main {
    
    static int w, h;
    static boolean[][][] board;
    static int[] dy = {1, -1 ,0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[] ky = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] kx = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    public static void main(String[] args) throws Exception {
        int k = read();
        w = read();
        h = read();
        board = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (read() == 1) Arrays.fill(board[i][j], true);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0, 0, k});
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == h - 1 && cur[1] == w - 1) {
                System.out.println(cur[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i], x = cur[1] + dx[i];
                if (isValid(y, x, cur[3]))
                    dq.offer(new int[] {y, x, cur[2] + 1, cur[3]});
            }
            if (cur[3] > 0) {
                for (int i = 0; i < 8; i++) {
                    int y = cur[0] + ky[i], x = cur[1] + kx[i];
                    if (isValid(y, x, cur[3] - 1))
                        dq.offer(new int[] {y, x, cur[2] + 1, cur[3] - 1});
                }
            }
        }
        System.out.println(-1);
    }
    private static boolean isValid(int y, int x, int k) {
        if (0 <= y && y < h && 0 <= x && x < w && !board[y][x][k]){
            board[y][x][k] = true;
            return true;
        }
        return false;
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static int ey, ex;
    static boolean[][] board;
    static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new boolean[r][c];
        int sy = 0, sx = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                char c = line[j];
                if (c == 'S') {
                    sy = i;
                    sx = j;
                } else if (c == 'D') {
                    ey = i;
                    ex = j;
                } else if (c == 'X')
                    board[i][j] = true;
                else if (c == '*')
                    dq.offer(new int[] { i, j, 1 });
            }
        }
        dq.offer(new int[] { sy, sx, 0 });
        board[sy][sx] = true;
        int time = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1], t = cur[2];
                if (t == 0 && y == ey && x == ex) {
                    System.out.println(time);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (isValid(ny, nx) && isPossible(ny, nx, t)) {
                        dq.offer(new int[] { ny, nx, t });
                        board[ny][nx] = true;
                    }
                }
            }
            time++;
        }
        System.out.println("KAKTUS");
    }

    private static boolean isPossible(int y, int x, int t) {
        if (board[y][x])
            return false;
        if (t == 1 && y == ey && x == ex)
            return false;
        return true;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c;
    }
}
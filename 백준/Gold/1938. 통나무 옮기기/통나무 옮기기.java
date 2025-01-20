import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n;
    static boolean[][] board;
    static int[][][] visited;
    static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        visited = new int[n][n][2];
        int[][] bArr = new int[3][2];
        int[][] eArr = new int[3][2];
        int bIdx = 0, eIdx = 0;
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                visited[i][j] = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
                if (line[j] == 'B')
                    bArr[bIdx++] = new int[] { i, j };
                else if (line[j] == 'E')
                    eArr[eIdx++] = new int[] { i, j };
                else if (line[j] == '1')
                    board[i][j] = true;
            }
        }
        int sy = bArr[1][0], sx = bArr[1][1], st = bArr[0][0] == bArr[1][0] ? 0 : 1;
        int ey = eArr[1][0], ex = eArr[1][1], et = eArr[0][0] == eArr[1][0] ? 0 : 1;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx, st });
        visited[sy][sx][st] = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1], t = cur[2];
            if (y == ey && x == ex && t == et) {
                System.out.println(visited[y][x][t]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isValid(ny, nx, t) && visited[y][x][t] + 1 < visited[ny][nx][t]) {
                    dq.offer(new int[] { ny, nx, t });
                    visited[ny][nx][t] = visited[y][x][t] + 1;
                }
            }
            if (canRotate(y, x)) {
                int nt = t == 0 ? 1 : 0;
                if (visited[y][x][t] + 1 < visited[y][x][nt]) {
                    dq.offer(new int[] { y, x, nt });
                    visited[y][x][nt] = visited[y][x][t] + 1;
                }
            }
        }
        System.out.println(0);
    }

    private static boolean canRotate(int y, int x) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int ny = y - 1 + i, nx = x - 1 + j;
                if (!isValid(ny, nx) || board[ny][nx])
                    return false;
            }
        return true;
    }

    private static boolean isValid(int y, int x, int t) {
        if (t == 0) {
            if (isValid(y, x - 1) && isValid(y, x) && isValid(y, x + 1))
                if (!board[y][x - 1] && !board[y][x] && !board[y][x + 1])
                    return true;
        } else {
            if (isValid(y - 1, x) && isValid(y, x) && isValid(y + 1, x))
                if (!board[y - 1][x] && !board[y][x] && !board[y + 1][x])
                    return true;
        }
        return false;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
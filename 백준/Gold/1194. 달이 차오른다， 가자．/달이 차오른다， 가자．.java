import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] board;

    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int sy = 0, sx = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '0') {
                    sy = i;
                    sx = j;
                }
            }
        }
        boolean[][][] visited = new boolean[n][m][1 << 6];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx, 0, 0 });
        visited[sy][sx][0] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1], keys = cur[2], moveCnt = cur[3];
            if (board[y][x] == '1') {
                System.out.println(moveCnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                int newKeys = keys;

                if (!isValid(ny, nx) || board[ny][nx] == '#' || visited[ny][nx][keys]) {
                    continue;
                }

                if (isKey(ny, nx))
                    newKeys |= (1 << (board[ny][nx] - 'a'));
                else if (isDoor(ny, nx) && (keys & (1 << (board[ny][nx] - 'A'))) == 0)
                    continue;

                if (!visited[ny][nx][newKeys]) {
                    dq.offer(new int[] { ny, nx, newKeys, moveCnt + 1 });
                    visited[ny][nx][newKeys] = true;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isKey(int y, int x) {
        return 'a' <= board[y][x] && board[y][x] <= 'f';
    }

    private static boolean isDoor(int y, int x) {
        return 'A' <= board[y][x] && board[y][x] <= 'F';
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
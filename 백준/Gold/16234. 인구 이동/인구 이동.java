import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r;
    static int[][] board;
    static boolean[][] visited;

    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        int time = 0;
        while (separate()) {
            time++;
        }
        System.out.println(time);
    }

    private static boolean separate() {
        visited = new boolean[n][n];
        boolean flg = false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (visited[i][j])
                    continue;
                for (int k = 0; k < 2; k++) {
                    int ni = i + dy[k];
                    int nj = j + dx[k];
                    if (isPossible(i, j, ni, nj)) {
                        flg = true;
                        distribute(ni, nj);
                    }
                }
            }
        return flg;
    }

    private static void distribute(int sy, int sx) {
        int cnt = 0, sum = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        ArrayList<int[]> info = new ArrayList<>();
        dq.offer(new int[] { sy, sx });
        visited[sy][sx] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1];
            cnt++;
            sum += board[y][x];
            info.add(new int[] { y, x });
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (isPossible(y, x, ny, nx)) {
                    visited[ny][nx] = true;
                    dq.offer(new int[] { ny, nx });
                }
            }
        }
        int avg = sum / cnt;
        for (int i = 0; i < info.size(); i++) {
            int y = info.get(i)[0], x = info.get(i)[1];
            board[y][x] = avg;
        }
    }

    private static boolean isPossible(int y, int x, int ny, int nx) {
        if (isValid(ny, nx) && !visited[ny][nx]) {
            int diff = Math.abs(board[y][x] - board[ny][nx]);
            if (l <= diff && diff <= r) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
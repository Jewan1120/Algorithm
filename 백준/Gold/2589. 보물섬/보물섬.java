import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = line.charAt(j) == 'L';
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (board[i][j]) {
                    maxLen = Math.max(maxLen, findMaxLen(i, j));
                }
            }
        System.out.println(maxLen);
    }

    private static int findMaxLen(int sy, int sx) {
        visited = new boolean[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx });
        visited[sy][sx] = true;
        int len = -1;
        while (!dq.isEmpty()) {
            int t = dq.size();
            while (t-- > 0) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (isValid(ny, nx) && board[ny][nx] && !visited[ny][nx]) {
                        dq.offer(new int[] { ny, nx });
                        visited[ny][nx] = true;
                    }
                }
            }
            len++;
        }
        return len;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
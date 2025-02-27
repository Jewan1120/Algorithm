import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, m, t;
    static int[][] board;
    static boolean[][] visited;
    static int totalSum = 0, totalCnt = 0;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        t = read();
        board = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                board[i][j] = read();
                totalSum += board[i][j];
                totalCnt++;
            }
        int x, d, k, sum;
        double avg;
        boolean isChanged;
        for (int i = 0; i < t; i++) {
            x = read();
            d = read();
            k = read();
            rotate(x, d, k);
            isChanged = false;
            visited = new boolean[n][m];
            for (int r = 0; r < n; r++)
                for (int c = 0; c < m; c++) {
                    if (board[r][c] != 0 && !visited[r][c]) {
                        sum = bfs(r, c);
                        if (sum != 0) {
                            sum += board[r][c];
                            board[r][c] = 0;
                            isChanged = true;
                            totalCnt--;
                        }
                        totalSum -= sum;
                    }
                }
            if (!isChanged) {
                avg = (double) totalSum / totalCnt;
                for (int r = 0; r < n; r++)
                    for (int c = 0; c < m; c++) {
                        if (board[r][c] == 0)
                            continue;
                        if (board[r][c] > avg) {
                            board[r][c]--;
                            totalSum--;
                        } else if (board[r][c] < avg) {
                            board[r][c]++;
                            totalSum++;
                        }
                    }
            }
        }
        System.out.println(totalSum);
    }

    private static void rotate(int x, int d, int k) {
        boolean dir = d == 0;
        int value = 0;
        for (int i = x - 1; i < n; i += x) {
            for (int j = 0; j < k; j++)
                if (dir) {
                    value = board[i][m - 1];
                    System.arraycopy(board[i], 0, board[i], 1, m - 1);
                    board[i][0] = value;
                } else {
                    value = board[i][0];
                    System.arraycopy(board[i], 1, board[i], 0, m - 1);
                    board[i][m - 1] = value;
                }
        }
    }

    private static int bfs(int sr, int sc) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sr, sc });
        visited[sr][sc] = true;
        int sum = 0, r, c, nr, nc;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            r = cur[0];
            c = cur[1];
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = (c + dc[i] + m) % m;
                if (isValid(nr, nc) && !visited[nr][nc] && board[nr][nc] == board[sr][sc]) {
                    sum += board[nr][nc];
                    board[nr][nc] = 0;
                    dq.offer(new int[] { nr, nc });
                    visited[nr][nc] = true;
                    totalCnt--;
                }
            }
        }
        return sum;
    }

    private static boolean isValid(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
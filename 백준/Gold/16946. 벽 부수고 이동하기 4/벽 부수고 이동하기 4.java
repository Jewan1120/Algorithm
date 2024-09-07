import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Main {

    static int n, m;
    static int[][] board;
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                board[i][j] = System.in.read() - '0';
            System.in.read();
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 1;
        hm.put(idx, 0);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (board[i][j] == 0) {
                    board[i][j] = ++idx;
                    int cnt = 1;
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.offer(new int[] { i, j });
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        for (int k = 0; k < 4; k++) {
                            int y = cur[0] + dy[k];
                            int x = cur[1] + dx[k];
                            if (isValid(y, x) && board[y][x] == 0) {
                                board[y][x] = idx;
                                cnt++;
                                dq.offer(new int[] { y, x });
                            }
                        }
                    }
                    hm.put(idx, cnt);
                }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    int sum = 1;
                    boolean[] visited = new boolean[idx + 1];
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];
                        if (isValid(y, x) && !visited[board[y][x]]) {
                            sum += hm.get(board[y][x]);
                            visited[board[y][x]] = true;
                        }
                    }
                    sb.append(sum % 10);
                } else
                    sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
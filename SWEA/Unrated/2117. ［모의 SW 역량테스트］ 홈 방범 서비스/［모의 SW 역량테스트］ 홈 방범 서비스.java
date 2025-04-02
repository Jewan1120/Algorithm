import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    static int n, m, homeCnt, maxK;
    static int[][][] board;
    static boolean[][] isPossible;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxK = n % 2 == 0 ? n + 1 : n;
            board = new int[maxK + 1][n][n];
            homeCnt = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    if (st.nextToken().charAt(0) == '1') {
                        homeCnt++;
                        bfs(i, j);
                    }
            }
            compress();
            isPossible = new boolean[maxK + 1][homeCnt + 1];
            calculate();
            int answer = 0;
            for (int k = 1; k <= maxK; k++) {
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        if (isPossible[k][board[k][i][j]]) {
                            answer = Math.max(answer, board[k][i][j]);
                        }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int sy, int sx) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        dq.offer(new int[] { sy, sx, 1 });
        visited[sy][sx] = true;
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1], k = cur[2];
                board[k][y][x]++;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (isValid(ny, nx, k + 1) && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        dq.offer(new int[] { ny, nx, k + 1 });
                    }
                }
            }
        }
    }

    private static void compress() {
        for (int k = 1; k <= maxK; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    board[k][i][j] += board[k - 1][i][j];
    }

    private static void calculate() {
        for (int i = 1; i <= maxK; i++)
            for (int j = 1; j <= homeCnt; j++)
                isPossible[i][j] = j * m >= i * i + (i - 1) * (i - 1);
    }

    private static boolean isValid(int y, int x, int k) {
        return 0 <= y && y < n && 0 <= x && x < n && 0 <= k && k <= maxK;
    }
}
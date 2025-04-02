import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
    
    private static int n, m;
    private static int sy, sx, l;

    private static int[][] board;
    private static boolean[][] visited;

    private static boolean[][] pipes = { { false, false, false, false }, { true, true, true, true },
            { true, true, false, false }, { false, false, true, true }, { true, false, false, true },
            { false, true, false, true }, { false, true, true, false }, { true, false, true, false } };

    private static int[] dy = { -1, 1, 0, 0 };
    private static int[] dx = { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= t; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(new int[] { sy, sx });
            visited[sy][sx] = true;
            int total = 0;
            while (!dq.isEmpty()) {
                if (l-- == 0)
                    break;
                int cnt = dq.size();
                while (cnt-- > 0) {
                    int[] cur = dq.poll();
                    int y = cur[0], x = cur[1];
                    total++;
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i], nx = x + dx[i];
                        if (isValid(ny, nx) && !visited[ny][nx] && isPossible(y, x, ny, nx, i)) {
                            dq.offer(new int[] { ny, nx });
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
            sb.append("#").append(tt).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible(int y, int x, int ny, int nx, int type) {
        boolean[] pipeA = pipes[board[y][x]];
        boolean[] pipeB = pipes[board[ny][nx]];
        if (type == 0)
            return pipeA[0] && pipeB[1];
        if (type == 1)
            return pipeA[1] && pipeB[0];
        if (type == 2)
            return pipeA[2] && pipeB[3];
        return pipeA[3] && pipeB[2];
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
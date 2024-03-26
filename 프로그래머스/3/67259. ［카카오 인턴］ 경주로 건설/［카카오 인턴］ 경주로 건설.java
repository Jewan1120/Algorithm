import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;
class Solution {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = dp[0][0][1] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0, -1});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1], dir = cur[2];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                boolean curv = dir == i / 2 ? false : true;
                if (0 <= ny && ny < n && 0 <= nx && nx < n && board[ny][nx] != 1) { 
                    if (dir == -1) {
                        dp[ny][nx][i / 2] = 100;
                        dq.offer(new int[] {ny, nx, i / 2});
                        continue;
                    }
                    if (!curv) {
                        if (dp[y][x][dir] + 100 < dp[ny][nx][i / 2]) {
                            dp[ny][nx][i / 2] = dp[y][x][dir] + 100;
                            dq.offer(new int[] {ny, nx, i / 2});
                        }
                    } else {
                        if (dp[y][x][dir] + 600 < dp[ny][nx][i / 2]) {
                            dp[ny][nx][i / 2] = dp[y][x][dir] + 600;
                            dq.offer(new int[] {ny, nx, i / 2});
                        }
                    }
                }
            }
        }
        answer = Math.min(dp[n - 1][n - 1][0], dp[n - 1][n - 1][1]);
        return answer;
    }
}
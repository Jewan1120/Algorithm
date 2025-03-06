import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[][] board;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            int maxValue = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    maxValue = Math.max(maxValue, board[i][j]);
                }
            }
            int maxAreaCnt = 0;
            for (int i = 0; i <= maxValue; i++) {
                int areaCnt = calcAreaCnt(i);
                maxAreaCnt = Math.max(maxAreaCnt, areaCnt);
            }
            sb.append("#").append(tc).append(" ").append(maxAreaCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static int calcAreaCnt(int value) {
        int areaCnt = 0;
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || board[i][j] <= value)
                    continue;
                areaCnt++;
                dq.offer(new int[] { i, j });
                visited[i][j] = true;
                while (!dq.isEmpty()) {
                    int[] cur = dq.poll();
                    int y = cur[0], x = cur[1];
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d], nx = x + dx[d];
                        if (isValid(ny, nx) && !visited[ny][nx] && board[ny][nx] > value) {
                            dq.offer(new int[] { ny, nx });
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        return areaCnt;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}

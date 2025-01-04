import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[] dy = { 1, -1, 0, 0 }, dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tt = 1; tt <= t; tt++) {
            n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            int[][] visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                Arrays.fill(visited[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 1)
                        visited[i][j] = -1;
                }
            }
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            Deque<int[]> dq = new ArrayDeque<>();
            visited[sy][sx] = 0;
            dq.offer(new int[] { 0, sy, sx });
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                int turn = cur[0], y = cur[1], x = cur[2];
                if (y == ey && x == ex) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i], nextTurn = turn + 1;
                    if (isValid(ny, nx) && visited[ny][nx] > nextTurn) {
                        if (board[ny][nx] == 2) {
                            nextTurn += 2 - (turn % 3);
                        }
                        dq.offer(new int[] { nextTurn, ny, nx });
                        visited[ny][nx] = nextTurn;
                    }
                }
            }
            int answer = visited[ey][ex] == Integer.MAX_VALUE ? -1 : visited[ey][ex];
            sb.append("#").append(tt).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
 
public class Solution {
 
    static int n;
    static boolean[][] board, visited;
    static int[] dy = { 1, -1, 0, 0, -1, -1, 1, 1 };
    static int[] dx = { 0, 0, 1, -1, -1, 1, 1, -1 };
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new boolean[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < n; j++)
                    if (line[j] == '*')
                        checkMine(i, j);
            }
            int totalCnt = simulate();
            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void checkMine(int y, int x) {
        board[y][x] = true;
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (isValid(ny, nx))
                board[ny][nx] = true;
        }
    }
 
    private static int simulate() {
        int totalCnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j] && !board[i][j]) {
                    bfs(i, j);
                    totalCnt++;
                }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j])
                    totalCnt++;
        return totalCnt;
    }
 
    private static void bfs(int sy, int sx) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx });
        visited[sy][sx] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1];
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isValid(ny, nx) && !visited[ny][nx]) {
                    if (!board[ny][nx])
                        dq.offer(new int[] { ny, nx });
                    visited[ny][nx] = true;
                }
            }
        }
    }
 
    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
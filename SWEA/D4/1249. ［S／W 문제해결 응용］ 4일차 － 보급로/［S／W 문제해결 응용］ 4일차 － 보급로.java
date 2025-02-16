import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    static int n;
    static int[][] board, visited;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                Arrays.fill(visited[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++)
                    board[i][j] = line.charAt(j) - '0';
            }
            sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[] { 0, 0, 0 });
        visited[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int y = cur[0], x = cur[1], w = cur[2];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isValid(ny, nx) && visited[ny][nx] > w + board[ny][nx]) {
                    pq.offer(new int[] { ny, nx, w + board[ny][nx] });
                    visited[ny][nx] = w + board[ny][nx];
                }
            }
        }
        return visited[n - 1][n - 1];
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
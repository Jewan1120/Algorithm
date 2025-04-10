import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    static int n, w, h, minCnt;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    static class Info {
        int[][] board;
        int[] top;

        Info(int[][] board, int[] top) {
            this.board = board;
            this.top = top;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            minCnt = Integer.MAX_VALUE;
            int[][] board = new int[h][w];
            int[] top = new int[w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int p = Integer.parseInt(st.nextToken());
                    if (p == 0)
                        continue;
                    board[i][j] = p;
                    top[j]++;
                }
            }
            recursive(0, new Info(board, top));
            sb.append("#").append(tc).append(" ").append(minCnt != Integer.MAX_VALUE ? minCnt : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth, Info info) {
        if (depth == n) {
            int cnt = 0;
            for (int i = 0; i < w; i++)
                cnt += info.top[i];
            minCnt = Math.min(minCnt, cnt);
            return;
        }
        for (int i = 0; i < w; i++) {
            if (info.top[i] == 0)
                continue;
            Info nextInfo = simulate(i, info);
            recursive(depth + 1, nextInfo);
        }
    }

    private static Info simulate(int sx, Info info) {
        boolean[][] removedBoard = bfs(info.board, h - info.top[sx], sx);
        int[] nextTop = new int[w];
        int[][] nextBoard = new int[h][w];
        for (int i = 0; i < w; i++) {
            for (int j = h - 1; j >= 0; j--) {
                if (removedBoard[j][i] || info.board[j][i] == 0)
                    continue;
                nextBoard[h - ++nextTop[i]][i] = info.board[j][i];
            }
        }
        return new Info(nextBoard, nextTop);
    }

    private static boolean[][] bfs(int[][] board, int sy, int sx) {
        boolean[][] removedBoard = new boolean[h][w];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { sy, sx });
        removedBoard[sy][sx] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1], p = board[y][x];
            if (p < 2)
                continue;
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < p; j++) {
                    int ny = y + dy[i] * j, nx = x + dx[i] * j;
                    if (isValid(ny, nx) && !removedBoard[ny][nx]) {
                        dq.offer(new int[] { ny, nx });
                        removedBoard[ny][nx] = true;
                    }
                }
            }
        }
        return removedBoard;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int n, minCost, maxCount;
    static int[][] board;
    static ArrayList<int[]> cores;
    static int[] dy = { -1, 0, 1, 0 }, dx = { 0, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            cores = new ArrayList<>();
            minCost = Integer.MAX_VALUE;
            maxCount = 0;
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 1) {
                        cores.add(new int[] { i, j });
                    }
                }
            }
            recursive(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(minCost).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth, int totalCount, int totalCost) {
        if (totalCount + (cores.size() - depth) < maxCount)
            return;
        if (totalCount + (cores.size() - depth) == maxCount && totalCost >= minCost)
            return;
        if (depth == cores.size()) {
            if (totalCount > maxCount) {
                maxCount = totalCount;
                minCost = totalCost;
            } else if (totalCount == maxCount)
                minCost = Math.min(minCost, totalCost);
            return;
        }
        recursive(depth + 1, totalCount, totalCost);
        for (int i = 0; i < 4; i++) {
            int sy = cores.get(depth)[0], sx = cores.get(depth)[1];
            int ny = sy + dy[i], nx = sx + dx[i];
            int cost = 0;
            while (isValid(ny, nx)) {
                if (board[ny][nx] != 0)
                    break;
                board[ny][nx] = 2;
                cost++;
                ny += dy[i];
                nx += dx[i];
            }
            if (!isValid(ny, nx)) {
                recursive(depth + 1, totalCount + 1, totalCost + cost);
            }
            if (cost != 0)
                backtracking(sy, sx, i, cost);
        }
    }

    private static void backtracking(int sy, int sx, int dir, int cost) {
        int ny = sy, nx = sx;
        while (cost-- > 0) {
            ny += dy[dir];
            nx += dx[dir];
            board[ny][nx] = 0;
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
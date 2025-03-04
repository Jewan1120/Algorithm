import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, dir;
    static int[][] board;
    static boolean[][] merged;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dir = getDir(st.nextToken());
            board = new int[n][n];
            merged = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            move();
            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    sb.append(board[i][j]).append(" ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int getDir(String oper) {
        switch (oper) {
        case "up":
            return 0;
        case "down":
            return 1;
        case "left":
            return 2;
        case "right":
            return 3;
        }
        return -1;
    }

    private static void move() {
        for (int i = 1; i < n; i++)
            for (int j = 0; j < n; j++) {
                switch (dir) {
                case 0:
                    goStraight(i, j);
                    break;
                case 1:
                    goStraight(n - 1 - i, j);
                    break;
                case 2:
                    goStraight(j, i);
                    break;
                case 3:
                    goStraight(j, n - 1 - i);
                    break;
                }
            }
    }

    private static void goStraight(int y, int x) {
        if (board[y][x] == 0)
            return;
        int value = board[y][x];
        int ny = y, nx = x;
        while (true) {
            int ty = ny + dy[dir], tx = nx + dx[dir];
            if (!isValid(ty, tx) || board[ty][tx] != 0)
                break;
            board[ty][tx] = value;
            board[ny][nx] = 0;
            ny = ty;
            nx = tx;
        }
        int ty = ny + dy[dir], tx = nx + dx[dir];
        if (isValid(ty, tx) && board[ty][tx] == value && !merged[ty][tx]) {
            board[ty][tx] *= 2;
            board[ny][nx] = 0;
            merged[ty][tx] = true;
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
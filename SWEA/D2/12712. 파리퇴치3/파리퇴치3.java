import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m, maxScore;
    static int[][] board;
    static int[] dy = { 1, -1, 0, 0, -1, -1, 1, 1 };
    static int[] dx = { 0, 0, 1, -1, -1, 1, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tt = 1; tt <= t; tt++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxScore = 0;
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            simulate();
            sb.append("#").append(tt).append(" ").append(maxScore).append("\n");
        }
        System.out.println(sb);
    }

    private static void simulate() {
        int score, ny, nx;
        for (int y = 0; y < n; y++)
            for (int x = 0; x < n; x++) {
                score = board[y][x];
                for (int i = 0; i < 4; i++)
                    for (int j = 1; j < m; j++) {
                        ny = y + dy[i] * j;
                        nx = x + dx[i] * j;
                        if (isValid(ny, nx))
                            score += board[ny][nx];
                    }
                maxScore = Math.max(maxScore, score);
                score = board[y][x];
                for (int i = 4; i < 8; i++)
                    for (int j = 1; j < m; j++) {
                        ny = y + dy[i] * j;
                        nx = x + dx[i] * j;
                        if (isValid(ny, nx))
                            score += board[ny][nx];
                    }
                maxScore = Math.max(maxScore, score);
            }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
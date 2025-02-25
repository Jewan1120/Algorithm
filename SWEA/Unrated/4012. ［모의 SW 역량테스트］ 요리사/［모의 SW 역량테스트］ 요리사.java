import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, minDiff;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            recursive(0, 0);
            sb.append("#").append(tc).append(" ").append(minDiff).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth, int group) {
        if (depth == n) {
            if (Integer.bitCount(group) == n / 2) {
                int scoreDiff = calculate(group);
                minDiff = Math.min(minDiff, scoreDiff);
            }
            return;
        }
        recursive(depth + 1, group);
        recursive(depth + 1, group | (1 << depth));
    }

    private static int calculate(int group) {
        int scoreDiff = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (((group >> i) & 1) == ((group >> j) & 1)) {
                    int score = board[i][j] + board[j][i];
                    if (((group >> i) & 1) == 0)
                        scoreDiff -= score;
                    else
                        scoreDiff += score;
                }
        return Math.abs(scoreDiff);
    }
}
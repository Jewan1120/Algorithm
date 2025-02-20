import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            board = new int[n + 1][n + 1];
            int maxValue = 0;
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n + 1; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken()) + board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
                    if (i >= m && j >= m) {
                        int value = board[i][j] - board[i - m][j] - board[i][j - m] + board[i - m][j - m];
                        maxValue = Math.max(maxValue, value);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
        }
        System.out.println(sb);
    }
}

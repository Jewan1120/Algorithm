import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int[][] board;
    static String[][] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tt = 1; tt <= t; tt++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            result = new String[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < 3; i++) {
                rotate();
                for (int j = 0; j < n; j++)
                    result[j][i] = arrToStr(board[j]);
            }
            sb.append("#").append(tt).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(result[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void rotate() {
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                next[j][n - i - 1] = board[i][j];
        board = next;
    }

    private static String arrToStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(arr[i]);
        return sb.toString();
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, len;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int[] line = new int[n];
                for (int j = 0; j < n; j++)
                    line[j] = board[i][j];
                if (isPossible(line))
                    cnt++;
            }
            for (int i = 0; i < n; i++) {
                int[] line = new int[n];
                for (int j = 0; j < n; j++)
                    line[j] = board[j][i];
                if (isPossible(line))
                    cnt++;
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible(int[] line) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int diff = line[i] - line[i + 1];
            if (Math.abs(diff) > 1)
                return false;
            if (diff == 1) {
                int s = i + 1;
                int lv = line[s];
                for (int j = 0; j < len; j++) {
                    if (!isValid(s + j) || visited[s + j] || line[s + j] != lv)
                        return false;
                    visited[s + j] = true;
                }
            } else if (diff == -1) {
                int s = i;
                int lv = line[s];
                for (int j = 0; j < len; j++) {
                    if (!isValid(s - j) || visited[s - j] || line[s - j] != lv)
                        return false;
                    visited[s - j] = true;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int x) {
        return 0 <= x && x < n;
    }
}

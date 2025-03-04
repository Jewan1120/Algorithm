import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int d, w, k;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            board = new boolean[d][w];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++)
                    board[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
            for (int i = 0; i <= k; i++)
                if (recursive(i, 0)) {
                    sb.append("#").append(tc).append(" ").append(i).append("\n");
                    break;
                }
        }
        System.out.println(sb);
    }

    private static boolean recursive(int depth, int p) {
        if (depth == 0)
            return isPossible();
        for (int i = p; i < d; i++) {
            boolean[] line = board[i].clone();
            Arrays.fill(board[i], true);
            if (recursive(depth - 1, i + 1))
                return true;
            board[i] = new boolean[w];
            if (recursive(depth - 1, i + 1))
                return true;
            board[i] = line;
        }
        return false;
    }

    private static boolean isPossible() {
        boolean flag;
        int cnt;
        for (int i = 0; i < w; i++) {
            flag = board[0][i];
            cnt = 1;
            for (int j = 1; j < d; j++) {
                if (flag == board[j][i])
                    cnt++;
                else {
                    flag = board[j][i];
                    cnt = 1;
                }
                if (cnt >= k)
                    break;
            }
            if (cnt < k)
                return false;
        }
        return true;
    }
}

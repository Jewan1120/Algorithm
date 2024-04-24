import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] result;
    static int[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new int[2];
        cut(0, n, 0, n);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
    
    public static void cut(int sh, int eh, int sw, int ew) {
        int c = board[sh][sw];
        for (int i = sh; i < eh; i++) {
            for (int j = sw; j < ew; j++) {
                if (board[i][j] != c) {
                    int mh = (sh + eh) / 2;
                    int mw = (sw + ew) / 2;
                    cut(sh, mh, sw, mw);
                    cut(sh, mh, mw, ew);
                    cut(mh, eh, sw, mw);
                    cut(mh, eh, mw, ew);
                    return;
                }
            }
        }
        result[c]++;
    }
}
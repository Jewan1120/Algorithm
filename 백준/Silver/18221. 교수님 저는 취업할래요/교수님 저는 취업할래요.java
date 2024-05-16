import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        boolean chk = false;
        int[] s = new int[2];
        int[] e = new int[2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                if (p == 2 || p == 5) {
                    if (!chk) {
                        s[0] = i;
                        s[1] = j;
                        chk = true;
                    } else {
                        e[0] = i;
                        e[1] = j;
                    }
                } else {
                    board[i][j] = p;
                }
            }
        }
        if (Math.pow(e[0] - s[0], 2) + Math.pow(e[1] - s[1], 2) >= 25) {
            int cnt = 0;
            int sy = Math.min(s[0], e[0]);
            int ey = Math.max(s[0], e[0]);
            int sx = Math.min(s[1], e[1]);
            int ex = Math.max(s[1], e[1]);
            for (int i = sy; i <= ey; i++) {
                for(int j = sx; j <= ex; j++) {
                    if (board[i][j] == 1) {
                        cnt++;
                    }
                    if (cnt == 3) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
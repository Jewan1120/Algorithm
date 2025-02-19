import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            board = new boolean[100][100];
            StringTokenizer st;
            int y = 99, x = 0;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    int p = Integer.parseInt(st.nextToken());
                    if (p == 1)
                        board[i][j] = true;
                    else if (p == 2)
                        x = j;
                }
            }
            while (y > 0) {
                if (0 <= x - 1 && board[y][x - 1])
                    x--;
                else if (x + 1 < 100 && board[y][x + 1])
                    x++;
                else
                    y--;
                board[y][x] = false;
            }
            sb.append("#").append(tc).append(" ").append(x).append("\n");
        }
        System.out.println(sb);
    }
}

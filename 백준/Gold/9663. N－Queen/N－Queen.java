import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] board;
    static int cnt = 0;
    static int n;
    static int[] dy = {-1, -1, -1};
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (!board[0][i]) {
                board[0][i] = true;
                dfs(1);
                board[0][i] = false;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(depth, i)) {
                board[depth][i] = true;
                dfs(depth + 1);
                board[depth][i] = false;
            }
        }
    }

    public static boolean isValid(int y, int x) {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= y; j++) {
                int ny = y + j * dy[i];
                int nx = x + j * dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < n && board[ny][nx]) {
                    return false;
                }
            }
        }
        return true;
    }
}
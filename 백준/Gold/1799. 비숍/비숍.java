import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[][] board;
    static boolean[][] bishop;
    static int maxBlack = 0, maxWhite = 0;
    static int[] dy = { -1, -1 };
    static int[] dx = { -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        bishop = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = st.nextToken().equals("1");
        }
        placeBishop(0, 0, true);
        placeBishop(1, 0, false);
        System.out.println(maxBlack + maxWhite);
    }

    private static void placeBishop(int depth, int cnt, boolean isBlack) {
        if (depth == n * n) {
            if (isBlack) {
                maxBlack = Math.max(maxBlack, cnt);
            } else {
                maxWhite = Math.max(maxWhite, cnt);
            }
            return;
        }
        int y = depth / n, x = depth % n;
        if ((y + x) % 2 != (isBlack ? 0 : 1)) {
            placeBishop(depth + 1, cnt, isBlack);
            return;
        }
        if (canPlace(y, x)) {
            bishop[y][x] = true;
            placeBishop(depth + 1, cnt + 1, isBlack);
            bishop[y][x] = false;
        }
        placeBishop(depth + 1, cnt, isBlack);
    }

    private static boolean canPlace(int y, int x) {
        if (!board[y][x])
            return false;
        for (int i = 1; i <= y; i++) {
            for (int j = 0; j < 2; j++) {
                int ny = y + dy[j] * i;
                int nx = x + dx[j] * i;
                if (isValid(ny, nx) && bishop[ny][nx])
                    return false;
            }
        }
        return true;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
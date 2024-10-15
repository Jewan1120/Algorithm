import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0
public class Main {

    static int H, W, L;
    static char[][] grid;
    static String word;
    static long[][][] dp;
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        word = br.readLine();

        dp = new long[H][W][L];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < L; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                result += dfs(i, j, 0);
            }
        }
        System.out.println(result);
    }

    static long dfs(int y, int x, int index) {
        if (dp[y][x][index] != -1) {
            return dp[y][x][index];
        }

        if (grid[y][x] != word.charAt(index)) {
            return dp[y][x][index] = 0;
        }

        if (index == L - 1) {
            return dp[y][x][index] = 1;
        }

        long count = 0;
        for (int dir = 0; dir < 8; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (isValid(ny, nx)) {
                count += dfs(ny, nx, index + 1);
            }
        }
        return dp[y][x][index] = count;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < H && 0 <= x && x < W;
    }
}
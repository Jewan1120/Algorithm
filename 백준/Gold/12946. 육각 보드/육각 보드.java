import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int cnt = 0;
    static boolean[][] board;
    static int[][] visited;
    static int[] dy = { -1, -1, 0, 1, 1, 0 };
    static int[] dx = { 0, 1, 1, 0, -1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'X') {
                    board[i][j] = true;
                }
                visited[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] && visited[i][j] == -1) {
                    recursive(i, j, 0);
                    if (cnt == 3) {
                        System.out.println(cnt);
                        return;
                    }
                }
        System.out.println(cnt);
    }

    private static void recursive(int y, int x, int num) {
        visited[y][x] = num;
        cnt = Math.max(cnt, 1);
        for (int i = 0; i < 6; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!isValid(ny, nx)) {
                continue;
            }
            if (board[ny][nx] && visited[ny][nx] == -1) {
                recursive(ny, nx, 1 - num);
                cnt = Math.max(cnt, 2);
            }
            if (visited[ny][nx] == num) {
                cnt = 3;
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}
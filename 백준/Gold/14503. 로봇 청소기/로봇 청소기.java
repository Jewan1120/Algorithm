import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int cnt = 0;
    static boolean[][] board;
    static boolean[][] cleaned;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        cleaned = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) == 0;
            }
        }
        dfs(sy, sx, sd);
        System.out.println(cnt);
    }
    
    public static void dfs(int y, int x, int d) {
        if (!cleaned[y][x]) {
            cleaned[y][x] = true;
            cnt++;
        }
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (valid(ny, nx) && board[ny][nx] && !cleaned[ny][nx]) {
                dfs(ny, nx, d);
                return;
            }
        }
        int by = y - dy[d];
        int bx = x - dx[d];
        if (valid(by, bx) && board[by][bx]) {
            dfs(by, bx, d);
        }
    }
    
    public static boolean valid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
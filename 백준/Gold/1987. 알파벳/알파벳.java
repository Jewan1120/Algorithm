import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] board;
    static boolean[] chk = new boolean[26];
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };
    static int maxLen = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        for (int i = 0; i < r; i++)
            board[i] = br.readLine().toCharArray();
        chk[board[0][0] - 'A'] = true;
        recursive(0, 0, 1);
        System.out.println(maxLen);
    }

    private static void recursive(int y, int x, int depth) {
        maxLen = Math.max(maxLen, depth);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isValid(ny, nx)) {
                chk[board[ny][nx] - 'A'] = true;
                recursive(ny, nx, depth + 1);
                chk[board[ny][nx] - 'A'] = false;
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c && !chk[board[y][x] - 'A'];
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static char[] cArr;
    static int n, m, len;
    static char[][] board;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        cArr = br.readLine().toCharArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        len = cArr.length;
        board = new char[n][m];
        for (int i = 0; i < n; i++)
            board[i] = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (strChk(i, j)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
    private static boolean strChk(int y, int x) {
        dir: for (int i = 0; i < 8; i++) {
            for (int j = 0; j < len; j++) {
                int ny = y + dy[i] * j;
                int nx = x + dx[i] * j;
                if (!isValid(ny, nx) || cArr[j] != board[ny][nx])
                    continue dir;
            }
            return true;
        }
        return false;
    }
    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }
}
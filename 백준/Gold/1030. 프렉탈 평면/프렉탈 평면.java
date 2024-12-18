import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int s, n, k, r1, r2, c1, c2;
    static boolean[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        board = new boolean[r2 - r1 + 1][c2 - c1 + 1];
        makeBoard(s, 0, 0, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j])
                    sb.append("1");
                else
                    sb.append("0");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void makeBoard(int depth, int y, int x, boolean tile) {
        int len = (int) Math.pow(n, depth);
        if (isNotOverlap(y, x, len)) {
            return;
        }
        if (depth == 0) {
            board[y - r1][x - c1] = tile;
            return;
        }
        int sLen = len / n;
        int bsy = y + sLen * (n - k) / 2, bsx = x + sLen * (n - k) / 2;
        int bLen = sLen * k;
        for (int i = y; i < y + len; i += sLen) {
            for (int j = x; j < x + len; j += sLen) {
                makeBoard(depth - 1, i, j, tile | isBlack(bsy, bsx, bLen, i, j));
            }
        }
    }

    private static boolean isNotOverlap(int y, int x, int len) {
        return y + len <= r1 || y > r2 || x + len <= c1 || x > c2;
    }

    private static boolean isBlack(int bsy, int bsx, int bLen, int y, int x) {
        return bsy <= y && y < bsy + bLen && bsx <= x && x < bsx + bLen;
    }
}
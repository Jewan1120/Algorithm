import java.util.ArrayList;

public class Main {

    static final int MAX_LEN = 101;
    static boolean[][] board = new boolean[MAX_LEN][MAX_LEN];
    static int[] dy = { 0, -1, 0, 1 }, dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        int n = read();
        while (n-- > 0) {
            int x = read(), y = read(), d = read(), g = read();
            draw(x, y, makeDragonCurve(d, g));
        }
        System.out.println(countSquares());
    }

    private static void draw(int sx, int sy, ArrayList<Integer> dragonCurve) {
        int ny = sy, nx = sx;
        board[ny][nx] = true;
        for (int dir : dragonCurve) {
            ny += dy[dir];
            nx += dx[dir];
            board[ny][nx] = true;
        }
    }

    private static ArrayList<Integer> makeDragonCurve(int d, int g) {
        ArrayList<Integer> dragonCurve = new ArrayList<>();
        dragonCurve.add(d);
        for (int i = 1; i <= g; i++) {
            int size = dragonCurve.size();
            for (int j = size - 1; j >= 0; j--)
                dragonCurve.add((dragonCurve.get(j) + 1) % 4);
        }
        return dragonCurve;
    }

    private static int countSquares() {
        int cnt = 0;
        for (int i = 0; i < MAX_LEN - 1; i++)
            for (int j = 0; j < MAX_LEN - 1; j++)
                if (board[i][j] & board[i + 1][j] & board[i][j + 1] & board[i + 1][j + 1])
                    cnt++;
        return cnt;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
public class Main {

    static int n, m, h;
    static boolean[][] ladders;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        h = read();
        ladders = new boolean[h][n - 1];
        for (int i = 0; i < m; i++) {
            int y = read(), x = read();
            ladders[y - 1][x - 1] = true;
        }
        for (int i = 0; i <= 3; i++) {
            if (placeLadder(0, i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static boolean placeLadder(int depth, int cnt) {
        if (depth == cnt)
            return simulate();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (isPossible(i, j)) {
                    ladders[i][j] = true;
                    if (placeLadder(depth + 1, cnt))
                        return true;
                    ladders[i][j] = false;
                }
            }
        }
        return false;
    }

    private static boolean isPossible(int y, int x) {
        if (ladders[y][x])
            return false;
        if ((x - 1 >= 0 && ladders[y][x - 1]) || (x + 1 < n - 1 && ladders[y][x + 1]))
            return false;
        return true;
    }

    private static boolean simulate() {
        for (int i = 0; i < n - 1; i++) {
            int num = i;
            for (int j = 0; j < h; j++) {
                int left = num - 1, right = num;
                if (left >= 0 && ladders[j][left])
                    num--;
                if (right < n - 1 && ladders[j][right])
                    num++;
            }
            if (num != i)
                return false;
        }
        return true;
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
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int n, k;
    static Deque<Integer> dq = new ArrayDeque<>();
    static int maxValue = 0, minValue = 10_001;
    static int H, W, R;
    static int h, w, r;
    static int[][] dough;
    static int[] dy = { 0, -1, 0, 1 }, dx = { -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        int v;
        for (int i = 0; i < n; i++) {
            v = read();
            dq.offer(v);
            maxValue = Math.max(maxValue, v);
            minValue = Math.min(minValue, v);
        }
        calculateDoughSize();
        int time = 0;
        while (maxValue - minValue > k) {
            initDough();
            press();
            outspread();
            halfDough();
            press();
            outspread();
            time++;
        }
        System.out.println(time);
    }

    private static void calculateDoughSize() {
        int i = 0;
        while ((int) ((i + 4) / 2) * (int) ((i + 3) / 2) <= n)
            i++;
        H = (i + 3) / 2;
        W = (i + 2) / 2;
        R = n - H * W;
    }

    private static void initDough() {
        h = H;
        w = W;
        r = R;
        dough = new int[h][w + r];
        for (int i = 0; i < h - 1; i++)
            for (int j = 0; j < r; j++)
                dough[i][w + j] = -1;
        int y = h - 1, x = w + r - 1, dir = 0;
        while (!dq.isEmpty()) {
            dough[y][x] = dq.pollLast();
            if (dough[y][x] == minValue)
                dough[y][x]++;
            if (!isValid(y + dy[dir], x + dx[dir]) || dough[y + dy[dir]][x + dx[dir]] != 0)
                dir = (dir + 1) % 4;
            y += dy[dir];
            x += dx[dir];
        }
    }

    private static void halfDough() {
        h = 4;
        w = n / 4;
        r = 0;
        dough = new int[h][w];
        for (int i = w - 1; i >= 0; i--)
            dough[3][i] = dq.pollLast();
        for (int i = w - 1; i >= 0; i--)
            dough[2][i] = dq.pollFirst();
        for (int i = 0; i < w; i++)
            dough[1][i] = dq.pollFirst();
        for (int i = 0; i < w; i++)
            dough[0][i] = dq.pollLast();
    }

    private static void press() {
        int[][] temp = new int[h][w + r];
        boolean[][] visited = new boolean[h][w + r];
        int ny, nx, d;
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w + r; x++) {
                visited[y][x] = true;
                if (dough[y][x] == -1)
                    continue;
                for (int dir = 0; dir < 4; dir++) {
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                    if (isValid(ny, nx) && !visited[ny][nx] && dough[ny][nx] != -1) {
                        d = Math.abs(dough[y][x] - dough[ny][nx]) / 5;
                        if (dough[y][x] > dough[ny][nx]) {
                            temp[y][x] -= d;
                            temp[ny][nx] += d;
                        } else if (dough[y][x] < dough[ny][nx]) {
                            temp[y][x] += d;
                            temp[ny][nx] -= d;
                        }
                    }
                }
            }
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w + r; x++) {
                if (temp[y][x] == 0)
                    continue;
                dough[y][x] += temp[y][x];
            }
    }

    private static void outspread() {
        maxValue = 0;
        minValue = 10_001;
        for (int x = 0; x < w + r; x++)
            for (int y = h - 1; y >= 0; y--) {
                if (dough[y][x] == -1)
                    break;
                dq.offer(dough[y][x]);
                maxValue = Math.max(maxValue, dough[y][x]);
                minValue = Math.min(minValue, dough[y][x]);
            }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w + r;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
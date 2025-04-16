import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static final int INACTIVE = 0, ACTIVE = 1, DEADED = 2;

    static int h, w;
    static Cell[][] cells;
    static int[] dy = { -1, 1, 0, 0 }, dx = { 0, 0, -1, 1 };

    static class Cell {
        int y, x, p, t, s;
        boolean isNew, canBreed;

        Cell(int y, int x, int p, boolean isNew) {
            this.y = y;
            this.x = x;
            this.p = p;
            t = p;
            s = INACTIVE;
            this.isNew = isNew;
            canBreed = false;
        }

        void spend() {
            if (isNew)
                isNew = false;
            else {
                t--;
                if (t == 0)
                    if (s == INACTIVE) {
                        t = p;
                        s = ACTIVE;
                        canBreed = true;
                    } else if (s == ACTIVE)
                        s = DEADED;

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            h = n + 2 * k;
            w = m + 2 * k;
            cells = new Cell[h][w];
            for (int y = k; y < k + n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = k; x < k + m; x++) {
                    int p = Integer.parseInt(st.nextToken());
                    if (p != 0) {
                        cells[y][x] = new Cell(y, x, p, false);
                    }
                }
            }
            int totalCnt = 0;
            while (k-- > 0) {
                breed();
                spendTime();
                totalCnt = calculate();
            }
            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void breed() {
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++) {
                if (cells[y][x] == null || !cells[y][x].canBreed)
                    continue;
                cells[y][x].canBreed = false;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (cells[ny][nx] == null)
                        cells[ny][nx] = new Cell(ny, nx, cells[y][x].p, true);
                    else if (cells[ny][nx].isNew && cells[ny][nx].p < cells[y][x].p)
                        cells[ny][nx] = new Cell(ny, nx, cells[y][x].p, true);
                }
            }
    }

    private static void spendTime() {
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++) {
                if (cells[y][x] == null || cells[y][x].s == DEADED)
                    continue;
                cells[y][x].spend();
            }
    }
    
    private static int calculate() {
        int cnt = 0;
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++) {
                if (cells[y][x] == null || cells[y][x].s == DEADED)
                    continue;
                cnt++;
            }
        return cnt;
    }
}
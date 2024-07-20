public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read(), wr = read(), wc = read();
        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {0, -1, 0, 1, 1, 1, 0, -1, -1};
        int[][] arr = new int[9][2];
        boolean[] chk = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int r = wr + dr[i];
            int c = wc + dc[i];
            arr[i] = new int[] {r, c};
            chk[i] = !(0 < r && r <= n && 0 < c && c <= n);
        }
        for (int i = 0; i < k; i++) {
            int r = read(), c = read();
            for (int j = 0; j < 9; j++) {
                int dy = r - arr[j][0];
                int dx = c - arr[j][1];
                float d = (float) dy / dx;
                if (dy == 0 || dx == 0 || Math.abs(d) == 1)
                    chk[j] = true;
            }
        }
        int cnt = 0;
        for (int i = 1; i < 9; i++)
            if (!chk[i])
                cnt++;
        if (chk[0]) {
            System.out.println(cnt != 0 ? "CHECK" : "CHECKMATE");
        } else {
            System.out.println(cnt != 0 ? "NONE" : "STALEMATE");
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
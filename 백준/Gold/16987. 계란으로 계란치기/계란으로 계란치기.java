public class Main {

    static int n;
    static int max;
    static int[][] eggs;
    static boolean[] possible;

    public static void main(String[] args) throws Exception {
        n = read();
        eggs = new int[n][2];
        possible = new boolean[n];
        for (int i = 0; i < n; i++) {
            eggs[i][0] = read();
            eggs[i][1] = read();
        }
        recursive(0);
        System.out.println(max);
    }

    private static void recursive(int p) {
        if (p == n) {
            int cnt = 0;
            for (boolean b : possible)
                if (b)
                    cnt++;
            max = Math.max(max, cnt);
            return;
        }
        if (possible[p])
            recursive(p + 1);
        else {
            boolean flg = false;
            for (int i = 0; i < n; i++) {
                if (i == p || possible[i])
                    continue;
                flg = true;
                eggs[p][0] -= eggs[i][1];
                eggs[i][0] -= eggs[p][1];
                possible[p] = eggs[p][0] <= 0;
                possible[i] = eggs[i][0] <= 0;
                recursive(p + 1);
                eggs[p][0] += eggs[i][1];
                eggs[i][0] += eggs[p][1];
                possible[p] = eggs[p][0] <= 0;
                possible[i] = eggs[i][0] <= 0;
            }
            if (!flg)
                recursive(p + 1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
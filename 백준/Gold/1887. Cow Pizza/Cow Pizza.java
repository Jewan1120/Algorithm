public class Main {

    static int[][] combi;
    static int t, n, cnt = 0;
    static boolean[] result;

    public static void main(String[] args) throws Exception {
        t = read();
        n = read();
        combi = new int[n][];
        result = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int z = read();
            combi[i] = new int[z];
            for (int j = 0; j < z; j++)
                combi[i][j] = read();
        }
        recursion(0);
        System.out.println(cnt);
    }

    private static void recursion(int depth) {
        if (depth == t) {
            if (isPossible()) {
                cnt++;
            }
            return;
        }
        result[depth] = true;
        recursion(depth + 1);
        result[depth] = false;
        recursion(depth + 1);
    }

    private static boolean isPossible() {
        for (int[] x : combi) {
            boolean flg = true;
            for (int i : x) {
                flg &= result[i - 1];
            }
            if (flg)
                return false;
        }
        return true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
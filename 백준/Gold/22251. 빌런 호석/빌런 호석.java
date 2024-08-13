public class Main {

    static boolean[][] LED = { { true, true, true, true, true, true, false },
            { false, true, true, false, false, false, false, }, { true, true, false, true, true, false, true },
            { true, true, true, true, false, false, true }, { false, true, true, false, false, true, true },
            { true, false, true, true, false, true, true }, { true, false, true, true, true, true, true },
            { true, true, true, false, false, false, false }, { true, true, true, true, true, true, true },
            { true, true, true, true, false, true, true } };

    static int[][] LtoL = new int[10][10];
    static int n, k, p, x;
    static int[] result;
    static int[] nums;
    static int[] init;
    static int answer = 0;

    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j)
                    continue;
                int cnt = 0;
                for (int k = 0; k < 7; k++) {
                    if (LED[i][k] ^ LED[j][k])
                        cnt++;
                }
                LtoL[i][j] = cnt;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        p = read();
        x = read();
        result = new int[k];
        nums = new int[k];
        init = new int[k];
        for (int i = 1; i <= k; i++) {
            init[k - i] = x % 10;
            x /= 10;
        }

        recursive(0, p);
        System.out.println(answer - 1);
    }

    private static void recursive(int depth, int possible) {
        if (depth == k) {
            counting(0);
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (possible - i >= 0) {
                result[depth] = i;
                recursive(depth + 1, possible - i);
            }
        }
    }

    private static void counting(int depth) {
        if (depth == k) {
            int num = 0;
            for (int i = 0; i < k; i++) {
                num *= 10;
                num += nums[i];
            }
            if (num <= n && num != 0)
                answer++;
            return;
        }
        int[] next = LtoL[init[depth]];
        for (int i = 0; i < 10; i++) {
            if (next[i] == result[depth]) {
                nums[depth] = i;
                counting(depth + 1);
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

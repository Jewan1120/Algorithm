public class Main {

    static final int INF = Integer.MAX_VALUE;

    static int n, m;
    static int[] arr;
    static int[][] sgt;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        sgt = new int[n << 2][2];
        build(1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int a = read(), b = read();
            int[] result = query(1, 0, n - 1, a - 1, b - 1);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void build(int idx, int s, int e) {
        if (s == e) {
            sgt[idx] = new int[] { arr[s], arr[e] };
        } else {
            int m = (s + e) >> 1;
            build(idx << 1, s, m);
            build((idx << 1) + 1, m + 1, e);
            sgt[idx] = new int[] { Math.min(sgt[idx << 1][0], sgt[(idx << 1) + 1][0]),
                    Math.max(sgt[idx << 1][1], sgt[(idx << 1) + 1][1]) };
        }
    }

    private static int[] query(int idx, int s, int e, int l, int r) {
        if (r < s || e < l)
            return new int[] { INF, 0 };
        if (l <= s && e <= r)
            return sgt[idx];
        int m = (s + e) >> 1;
        int[] lArr = query(idx << 1, s, m, l, r);
        int[] rArr = query((idx << 1) + 1, m + 1, e, l, r);
        return new int[] { Math.min(lArr[0], rArr[0]), Math.max(lArr[1], rArr[1]) };
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
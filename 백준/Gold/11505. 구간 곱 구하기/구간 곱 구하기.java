public class Main {

    static final int MOD = 1_000_000_007;

    static int n, m, k;
    static int[] arr;
    static int[] sgt;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        k = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        sgt = new int[n << 2];
        build(1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++)
            if (read() == 1)
                update(1, 0, n - 1, read() - 1, read());
            else
                sb.append(query(1, 0, n - 1, read() - 1, read() - 1)).append("\n");
        System.out.println(sb);
    }

    private static void build(int idx, int s, int e) {
        if (s == e)
            sgt[idx] = arr[s];
        else {
            int m = (s + e) >> 1;
            int il = idx << 1, ir = il | 1;
            build(il, s, m);
            build(ir, m + 1, e);
            sgt[idx] = (int) ((long) sgt[il] * sgt[ir] % MOD);
        }
    }

    private static void update(int idx, int s, int e, int target, int newValue) {
        if (s == e) {
            sgt[idx] = newValue;
        } else {
            int m = (s + e) >> 1;
            int il = idx << 1, ir = il | 1;
            if (target <= m)
                update(il, s, m, target, newValue);
            else
                update(ir, m + 1, e, target, newValue);
            sgt[idx] = (int) ((long) sgt[il] * sgt[ir] % MOD);
        }
    }

    private static int query(int idx, int s, int e, int l, int r) {
        if (r < s || e < l)
            return 1;
        if (l <= s && e <= r)
            return sgt[idx];
        int m = (s + e) >> 1;
        int il = idx << 1, ir = il | 1;
        return (int) ((long) query(il, s, m, l, r) * query(ir, m + 1, e, l, r) % MOD);
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

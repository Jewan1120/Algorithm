public class Main {

    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int[] arr;
    static int[][] sgt;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            arr[i] = read();
        sgt = new int[(n + 1) << 2][2];
        build(1, 1, n);
        int m = read(), oper, a, b;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            oper = read();
            a = read();
            b = read();
            if (oper == 1)
                update(1, 1, n, a, b);
            else
                sb.append(query(1, 1, n, a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static void build(int idx, int s, int e) {
        if (s == e)
            sgt[idx] = new int[] { arr[s], s };
        else {
            int m = (s + e) >> 1;
            build(idx << 1, s, m);
            build((idx << 1) + 1, m + 1, e);
            sgt[idx] = compare(sgt[idx << 1], sgt[(idx << 1) + 1]);
        }
    }

    private static int query(int idx, int s, int e, int l, int r) {
        if (r < s || e < l)
            return 0;
        else if (l <= s && e <= r)
            return sgt[idx][1];
        int m = (s + e) >> 1;
        int idxL = query(idx << 1, s, m, l, r);
        int idxR = query((idx << 1) + 1, m + 1, e, l, r);

        if (idxL == 0 || idxR == 0)
            return idxL + idxR;
        return arr[idxL] <= arr[idxR] ? idxL : idxR;
    }

    private static void update(int idx, int s, int e, int target, int newValue) {
        if (s == e) {
            arr[target] = newValue;
            sgt[idx] = new int[] { newValue, target };
        } else {
            int m = (s + e) >> 1;
            if (target <= m)
                update(idx << 1, s, m, target, newValue);
            else
                update((idx << 1) + 1, m + 1, e, target, newValue);
            sgt[idx] = compare(sgt[idx << 1], sgt[(idx << 1) + 1]);
        }
    }

    private static int[] compare(int[] a, int[] b) {
        if (a[0] == b[0])
            return a[1] < b[1] ? a : b;
        return a[0] < b[0] ? a : b;
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
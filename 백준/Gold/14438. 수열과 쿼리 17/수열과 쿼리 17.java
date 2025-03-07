public class Main {

    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int[] sgt;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        sgt = new int[n << 2];
        build(1, 0, n - 1);
        int m = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++)
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
            build(idx << 1, s, m);
            build((idx << 1) + 1, m + 1, e);
            sgt[idx] = Math.min(sgt[idx << 1], sgt[(idx << 1) + 1]);
        }
    }

    private static int query(int idx, int s, int e, int l, int r) {
        if (r < s || e < l)
            return INF;
        if (l <= s && e <= r)
            return sgt[idx];
        int m = (s + e) >> 1;
        int valueL = query(idx << 1, s, m, l, r);
        int valueR = query((idx << 1) + 1, m + 1, e, l, r);
        return Math.min(valueL, valueR);
    }

    private static void update(int idx, int s, int e, int target, int newValue) {
        if (s == e)
            sgt[idx] = newValue;
        else {
            int m = (s + e) >> 1;
            if (target <= m)
                update(idx << 1, s, m, target, newValue);
            else
                update((idx << 1) + 1, m + 1, e, target, newValue);
            sgt[idx] = Math.min(sgt[idx << 1], sgt[(idx << 1) + 1]);
        }
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
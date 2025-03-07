public class Main {

    static int n;
    static int[] arr;
    static int[][] sgt;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        sgt = new int[n << 2][2];
        build(1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        int m = read();
        for (int i = 0; i < m; i++) {
            int oper = read();
            if (oper == 1)
                update(1, 0, n - 1, read() - 1, read());
            else
                sb.append(query(1, oper, 0, n - 1, read() - 1, read() - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static void build(int idx, int s, int e) {
        if (s == e)
            sgt[idx][arr[s] % 2]++;
        else {
            int m = (s + e) >> 1;
            int l = idx << 1, r = l | 1;
            build(l, s, m);
            build(r, m + 1, e);
            sgt[idx][0] = sgt[idx << 1][0] + sgt[(idx << 1) + 1][0];
            sgt[idx][1] = sgt[idx << 1][1] + sgt[(idx << 1) + 1][1];
        }
    }

    private static void update(int idx, int s, int e, int target, int newValue) {
        if (s == e) {
            if ((arr[target] % 2) != (newValue % 2)) {
                sgt[idx][arr[target] % 2]--;
                sgt[idx][newValue % 2]++;
            }
            arr[target] = newValue;
        } else {
            int m = (s + e) >> 1;
            int l = idx << 1, r = l | 1;
            if (target <= m)
                update(l, s, m, target, newValue);
            else
                update(r, m + 1, e, target, newValue);
            sgt[idx][0] = sgt[l][0] + sgt[r][0];
            sgt[idx][1] = sgt[l][1] + sgt[r][1];
        }
    }

    private static int query(int idx, int oper, int s, int e, int l, int r) {
        if (r < s || e < l)
            return 0;
        if (l <= s && e <= r)
            return sgt[idx][oper % 2];
        int m = (s + e) >> 1;
        return query(idx << 1, oper, s, m, l, r) + query((idx << 1) + 1, oper, m + 1, e, l, r);
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
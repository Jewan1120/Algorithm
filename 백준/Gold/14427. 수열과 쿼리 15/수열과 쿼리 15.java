public class Main {

    static int n, m, oper;
    static int[][] sgt;
    static int[] arr;
    static int len;

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        sgt = new int[n << 2][2];
        build(1, 0, n - 1);
        m = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            oper = read();
            if (oper == 1) {
                update(1, 0, n - 1, read() - 1, read());
            } else {
                sb.append(sgt[1][1]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void build(int idx, int s, int e) {
        if (s == e)
            sgt[idx] = new int[] { arr[s], s + 1 };
        else {
            int m = (s + e) >> 1;
            build(idx << 1, s, m);
            build((idx << 1) + 1, m + 1, e);
            if (sgt[idx << 1][0] > sgt[(idx << 1) + 1][0])
                sgt[idx] = sgt[(idx << 1) + 1];
            else
                sgt[idx] = sgt[idx << 1];
        }
    }

    private static void update(int idx, int s, int e, int target, int newValue) {
        if (s == e)
            sgt[idx][0] = newValue;
        else {
            int m = (s + e) >> 1;
            if (target <= m)
                update(idx << 1, s, m, target, newValue);
            else
                update((idx << 1) + 1, m + 1, e, target, newValue);
            if (sgt[idx << 1][0] > sgt[(idx << 1) + 1][0])
                sgt[idx] = sgt[(idx << 1) + 1];
            else
                sgt[idx] = sgt[idx << 1];
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
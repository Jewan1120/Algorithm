import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
        long[] tree;
        int size;

        SegmentTree(long[] arr) {
            size = arr.length;
            tree = new long[size << 2];
            build(arr, 1, 0, size - 1);
        }

        private void build(long[] arr, int idx, int l, int r) {
            if (l == r)
                tree[idx] = arr[l];
            else {
                int m = (l + r) >> 1;
                build(arr, idx << 1, l, m);
                build(arr, (idx << 1) + 1, m + 1, r);
                tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
            }
        }

        public long query(int l, int r) {
            return query(1, 0, size - 1, l, r);
        }

        private long query(int idx, int s, int e, int l, int r) {
            if (r < s || e < l)
                return 0;
            if (l <= s && e <= r)
                return tree[idx];
            int m = (s + e) >> 1;
            long sumL = query(idx << 1, s, m, l, r);
            long sumR = query((idx << 1) + 1, m + 1, e, l, r);
            return sumL + sumR;
        }

        public void update(int target, long value) {
            update(1, 0, size - 1, target, value);
        }

        private void update(int idx, int s, int e, int target, long value) {
            if (s == e)
                tree[idx] = value;
            else {
                int m = (s + e) >> 1;
                if (target <= m)
                    update(idx << 1, s, m, target, value);
                else
                    update((idx << 1) + 1, m + 1, e, target, value);
                tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()),
                k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(br.readLine());
        SegmentTree sgt = new SegmentTree(arr);
        StringBuilder sb = new StringBuilder();
        int oper, a;
        long b;
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            oper = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Long.parseLong(st.nextToken());
            if (oper == 1)
                sgt.update(a, b);
            else
                sb.append(sgt.query(a, (int) b - 1)).append("\n");
        }
        System.out.println(sb);
    }
}
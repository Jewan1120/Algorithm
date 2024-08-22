import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read(), m = read();
            long sum = 0;
            int[] a1 = new int[n];
            int[] a2 = new int[m];
            for (int i = 0; i < n; i++)
                a1[i] = read();
            for (int i = 0; i < m; i++)
                a2[i] = read();
            Arrays.sort(a2);
            for (int i = 0; i < n; i++) {
                int l = 0, r = m - 1, value = 0;
                while (l <= r) {
                    int mid = (l + r) >>> 1;
                    if (a1[i] > a2[mid]) {
                        l = mid + 1;
                    } else if (a1[i] < a2[mid]) {
                        r = mid - 1;
                    } else {
                        value = a2[mid];
                        break;
                    }
                }
                l = Math.min(l, m - 1);
                r = Math.max(r, 0);
                if (value == 0) {
                    int d = Math.abs(a2[l] - a1[i]) - Math.abs(a2[r] - a1[i]);
                    if (d == 0)
                        value = Math.min(a2[l], a2[r]);
                    else if (d < 0)
                        value = a2[l];
                    else
                        value = a2[r];
                }
                sum += value;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
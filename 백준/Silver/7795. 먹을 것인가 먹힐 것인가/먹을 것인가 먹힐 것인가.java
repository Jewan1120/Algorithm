import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read(), m = read();
            int[] A = new int[n];
            for (int i = 0; i < n; i++)
                A[i] = read();
            int[] B = new int[m];
            for (int i = 0; i < m; i++)
                B[i] = read();
            Arrays.sort(A);
            Arrays.sort(B);
            int cnt = 0;
            for (int target : A) {
                int l = 0, r = B.length - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (B[mid] >= target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                cnt += l;
            }
            sb.append(cnt).append("\n");
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
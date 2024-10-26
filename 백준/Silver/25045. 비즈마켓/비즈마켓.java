import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = read();
        int[] B = new int[m];
        for (int i = 0; i < m; i++)
            B[i] = read();
        Arrays.sort(A);
        Arrays.sort(B);
        long sum = 0;
        for (int i = 0; i < Math.min(n, m); i++) {
            long p = A[n - i - 1] - B[i];
            if (p < 0)
                break;
            sum += p;
        }
        System.out.println(sum);
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
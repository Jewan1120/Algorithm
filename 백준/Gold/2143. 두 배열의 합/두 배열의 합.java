import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        int n = read();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = read();
        int m = read();
        int[] B = new int[m];
        for (int i = 0; i < m; i++)
            B[i] = read();
        HashMap<Integer, Integer> BMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                BMap.put(sum, BMap.getOrDefault(sum, 0) + 1);
            }
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                total += BMap.getOrDefault(t - sum, 0);
            }
        }
        System.out.println(total);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return m ? ~n + 1 : n;
    }
}
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] A = new int[n], B = new int[n], C = new int[n], D = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = read();
            B[i] = read();
            C[i] = read();
            D[i] = read();
        }
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        Arrays.sort(AB);
        Arrays.sort(CD);
        long total = 0;
        for (int i = 0; i < n * n; i++) {
            int target = -AB[i];
            int lower = lowerBound(CD, target);
            int upper = upperBound(CD, target);
            total += upper - lower;
        }
        System.out.println(total);
    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * Math.min(k, i);
        }
        System.out.println(sum);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        for (int i = n - 1; i > 1; i--)
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                System.out.println(arr[i] + arr[i - 1] + arr[i - 2]);
                return;
            }
        System.out.println(-1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int value = read();
            int idx = Arrays.binarySearch(arr, 0, len, value);
            if (idx < 0)
                idx = ~idx;
            arr[idx] = value;
            if (idx == len)
                len++;
        }
        System.out.println(n - len);
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
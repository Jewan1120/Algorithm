import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[] lis = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(lis, 0, len, arr[i]);
            if (idx < 0)
                idx = ~idx;
            lis[idx] = arr[i];
            if (idx == len)
                len++;
        }
        System.out.println(len);
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
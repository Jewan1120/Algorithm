import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), l = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        for (int i = 0; i < n && arr[i] <= l; i++)
            l++;
        System.out.println(l);
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
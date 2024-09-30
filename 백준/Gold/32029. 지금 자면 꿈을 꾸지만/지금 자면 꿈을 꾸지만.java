import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), A = read(), B = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        int max = 0;
        for (int X = 0; X < A; X++) {
            for (int i = 0; i <= n; i++) {
                int cnt = 0, time = 0;
                for (int j = 0; j < i; j++)
                    if (time + A <= arr[j]) {
                        cnt++;
                        time += A;
                    }
                time += (B * X);
                for (int j = i; j < n; j++)
                    if (time + A - X <= arr[j]) {
                        cnt++;
                        time += A - X;
                    }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
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
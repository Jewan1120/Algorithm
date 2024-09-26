import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), b = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
            arr[i] = new int[] { read(), read() };
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] price = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    price[j] = (arr[j][0] / 2) + arr[j][1];
                else
                    price[j] = arr[j][0] + arr[j][1];
            }
            Arrays.sort(price);
            int cnt = 0;
            long sum = 0;
            for (int p : price) {
                sum += (long) p;
                if (sum > b)
                    break;
                cnt++;
            }
            max = Math.max(max, cnt);
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
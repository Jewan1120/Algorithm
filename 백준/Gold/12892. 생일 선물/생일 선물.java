import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int d = read();
        int[][] gift = new int[n][2];
        for (int i = 0; i < n; i++)
            gift[i] = new int[] { read(), read() };
        Arrays.sort(gift, (o1, o2) -> o1[0] - o2[0]);
        long max = 0;
        long sum = 0;
        int l = 0, r = 0;
        while (l <= r && l < n && r < n) {
            int diff = gift[r][0] - gift[l][0];
            if (diff < d) {
                sum += gift[r][1];
                r++;
            } else {
                sum -= gift[l][1];
                l++;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        long n = read();
        long[] dice = new long[6];
        long sum = 0;
        for (int i = 0; i < 6; i++) {
            dice[i] = read();
        }
        if (n == 1) {
            Arrays.sort(dice);
            for (int i = 0; i < 5; i++)
                sum += dice[i];
            System.out.println(sum);
            return;
        }
        long min1 = 1_000_001;
        long min2 = 2_000_001;
        long min3 = 3_000_001;
        for (int i = 0; i < 6; i++) {
            min1 = Math.min(min1, dice[i]);
            for (int j = 0; j < 6; j++) {
                if (i == j || i + j == 5)
                    continue;
                min2 = Math.min(min2, dice[i] + dice[j]);
                for (int k = 0; k < 6; k++) {
                    if (i == k || j == k || i + k == 5 || j + k == 5)
                        continue;
                    min3 = Math.min(min3, dice[i] + dice[j] + dice[k]);
                }
            }
        }
        sum += min1 * (5 * Math.pow(n - 2, 2) + 4 * (n - 2));
        sum += min2 * (8 * n - 12);
        sum += min3 * 4;
        System.out.println(sum);
    }

    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
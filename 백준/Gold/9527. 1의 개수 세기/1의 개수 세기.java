import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//0
public class Main {

    static long[] dp = new long[55];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        dp[0] = 1;
        for (int i = 1; i < 55; i++)
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        System.out.println(getBitCount(b) - getBitCount(a - 1));
    }

    private static long getBitCount(long num) {
        long cnt = num & 1;
        int size = (int) (Math.log(num) / Math.log(2));
        for (int i = size; i > 0; i--) {
            if ((num & (1L << i)) != 0L) {
                cnt += dp[i - 1] + (num - (1L << i)) + 1;
                num -= (1L << i);
            }
        }
        return cnt;
    }
}
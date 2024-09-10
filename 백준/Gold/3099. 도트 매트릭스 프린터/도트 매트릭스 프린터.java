import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        int len = cArr.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 2;
        for (int i = 1; i < len; i++)
            for (int j = 0; j < i; j++) {
                int cost = 2 * (i - j - 1);
                if (cArr[i] == cArr[j])
                    dp[i] = Math.min(dp[i], dp[j] + cost + 1);
                else
                    dp[i] = Math.min(dp[i], dp[j] + cost + 2);
            }
        System.out.println(dp[len - 1]);
    }
}
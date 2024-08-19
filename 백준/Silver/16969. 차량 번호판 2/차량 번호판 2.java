import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long cnt = str.charAt(0) == 'c' ? 26 : 10;
        for (int i = 1; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == 'c') {
                if (now == str.charAt(i - 1))
                    cnt = (cnt * 25) % MOD;
                else
                    cnt = (cnt * 26) % MOD;
            } else {
                if (now == str.charAt(i - 1))
                    cnt = (cnt * 9) % MOD;
                else
                    cnt = (cnt * 10) % MOD;
            }
        }
        System.out.println(cnt % MOD);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()), k = Long.parseLong(st.nextToken());
        long N = factorial(n);
        long K = (factorial(n - k) * factorial(k)) % MOD;
        System.out.println(N * pow(K, MOD - 2) % MOD);
    }

    private static long factorial(long n) {
        long result = 1;
        while (n > 0) {
            result = (result * n) % MOD;
            n--;
        }
        return result;
    }

    private static long pow(long num, long p) {
        if (p == 1)
            return num % MOD;
        long next = pow(num, p / 2);
        if (p % 2 == 1) {
            return next * next % MOD * num % MOD;
        }
        return next * next % MOD;
    }
}
public class Main {

    static final long MOD = 1L << 32;

    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[] primes = new boolean[n + 1];
        primes[0] = primes[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]) {
                for (int j = i + i; j <= n; j += i)
                    primes[j] = true;
            }
        }
        long answer = 1;
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                long num = i;
                while (num * i <= n) {
                    num *= i;
                }
                answer = (answer * num) % MOD;
            }
        }
        System.out.println(answer);
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
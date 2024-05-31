public class Main {
    public static void main(String[] args) throws Exception {
        boolean[] prime = new boolean[1_000_001];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(1_000_000); i++)
            if (!prime[i])
                for (int j = i * i; j <= 1_000_000; j += i)
                    prime[j] = true;
        StringBuilder sb = new StringBuilder();
        int t = read();
        for (; t > 0; t--) {
            int n = read();
            int cnt = 0;
            for (int i = 2; i <= n / 2; i++)
                if (!prime[i] && !prime[n - i]) cnt++;
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

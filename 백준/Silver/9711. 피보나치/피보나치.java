public class Main {
    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            int p = read(), q = read();
            sb.append("Case #").append(i).append(": ").append(calFibo(p, q)).append("\n");
        }
        System.out.println(sb);
    }
    private static long calFibo(int p, int q) {
        if (p <= 2) return 1 % q;
        long fibo1 = 1 % q, fibo2 = 1 % q, cur = 0;
        for (int i = 3; i <= p; i++){
            cur = (fibo1 + fibo2) % q;
            fibo1 = fibo2;
            fibo2 = cur;
        }
        return cur;
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
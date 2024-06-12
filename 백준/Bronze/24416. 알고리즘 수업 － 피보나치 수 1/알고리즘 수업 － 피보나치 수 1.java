public class Main {
    static int[] fibo;
    public static void main(String[] args) throws Exception {
        int n = read();
        fibo = new int[n + 1];
        calFibo(n);
        System.out.println(fibo[n] + " " + (n - 2));
    }
    private static int calFibo(int n) {
        if (n == 1 || n == 2) return 1;
        if (fibo[n] == 0) fibo[n] = ((calFibo(n - 1) + calFibo(n - 2)));
        return fibo[n];
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
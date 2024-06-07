public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = read();
        }
        int t = read(), p = read(), sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sum += Math.ceil((double) arr[i] / t);
        }
        sb.append(sum).append("\n").append(n / p).append(" ").append(n % p);
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
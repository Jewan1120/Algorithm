public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int div = 2;
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            if(n % div == 0) {
                n /= div;
                sb.append(div).append("\n");
            } else div++;
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
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), m = 0, f = 0;
        while (m < n) m += ++f;
        StringBuilder sb = new StringBuilder();
        int t = m - n;
        if (f % 2 == 0) {
            sb.append(f - t).append("/").append(t + 1);
        } else {
            sb.append(t + 1).append("/").append(f - t);
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
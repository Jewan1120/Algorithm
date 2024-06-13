public class Main {
    public static void main(String[] args) throws Exception {
        int t = read(), x;
        StringBuilder sb = new StringBuilder();
        long sum = 0, xor = 0;
        while (t-- > 0) {
            switch (read()) {
                case 1:
                    x = read();
                    sum += x;
                    xor ^= x;
                    break;
                case 2:
                    x = read();
                    sum -= x;
                    xor ^= x;
                    break;
                case 3:
                    sb.append(sum).append("\n");
                    break;
                case 4:
                    sb.append(xor).append("\n");
                    break;
            }
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
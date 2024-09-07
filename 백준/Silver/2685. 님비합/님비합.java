public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int b = read(), x = read(), y = read();
            int result = 0, pow = 1;
            while (x > 0 || y > 0) {
                int sum = (x % b + y % b) % b;
                result += sum * pow;
                x /= b;
                y /= b;
                pow *= b;
            }
            sb.append(result).append("\n");
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
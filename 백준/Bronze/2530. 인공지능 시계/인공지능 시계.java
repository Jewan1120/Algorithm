public class Main {
    public static void main(String[] args) throws Exception {
        int a = read(), b = read(), c = read(), d = read();
        int time = (a * 3600 + b * 60 + c + d) % 86400;
        StringBuilder sb = new StringBuilder();
        sb.append((time / 3600) % 24).append(" ");
        sb.append((time / 60) % 60).append(" ");
        sb.append(time % 60);
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
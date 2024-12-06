public class Main {

    public static void main(String[] args) throws Exception {
        int t = read(), s = read();
        if (12 <= t && t <= 16 && s == 0)
            System.out.println(320);
        else
            System.out.println(280);
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
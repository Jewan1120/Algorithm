public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), newN = n, cnt = 0;
        do {
            newN = ((newN % 10) * 10) + (((newN / 10) + (newN % 10)) % 10);
            cnt++;
        }
        while (n != newN);
        System.out.println(cnt);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
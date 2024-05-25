public class Main {

    public static void main(String[] args) throws Exception {
        int x = read();
        int n = read();
        for (int i = 0; i < n; i++) {
            x -= read() * read();
        }
        System.out.println(x == 0 ? "Yes" : "No");
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
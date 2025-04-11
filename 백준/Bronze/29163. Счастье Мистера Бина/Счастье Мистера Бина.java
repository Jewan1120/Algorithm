public class Main {

    public static void main(String[] args) throws Exception {
        int o = 0, e = 0;
        int n = read();
        while (n-- > 0) {
            if (read() % 2 == 0)
                e++;
            else
                o++;
        }
        System.out.println(e > o ? "Happy" : "Sad");
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
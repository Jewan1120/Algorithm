public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        if (n > 198)
            System.out.println(0);
        else
            System.out.println(198 - n + 1);
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
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(read() * 60 + read());
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
public class Main {

    public static void main(String[] args) throws Exception {
        int ur = read(), tr = read(), uo = read(), to = read();
        System.out.println(ur * 56 + tr * 24 + uo * 14 + to * 6);
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
public class Main {

    public static void main(String[] args) throws Exception {
        if (read() == 0)
            System.out.println("divide by zero");
        else
            System.out.println("1.00");
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
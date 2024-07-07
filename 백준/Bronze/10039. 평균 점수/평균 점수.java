public class Main {

    public static void main(String[] args) throws Exception {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = read();
            if (n < 40)
                n = 40;
            sum += n;
        }
        System.out.println(sum / 5);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
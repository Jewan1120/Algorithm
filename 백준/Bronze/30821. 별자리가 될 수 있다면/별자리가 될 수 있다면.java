public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int answer = 1;
        for (int i = 0; i < 5; i++) {
            answer *= (n - i);
            answer /= (i + 1);
        }
        System.out.println(answer);
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
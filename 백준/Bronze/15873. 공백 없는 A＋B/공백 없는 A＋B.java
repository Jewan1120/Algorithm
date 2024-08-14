public class Main {
    public static void main(String[] args) throws Exception {
        int a = System.in.read() & 15;
        int b = System.in.read() & 15;
        if (b == 0) {
            a *= 10;
            b = System.in.read() & 15;
        }
        if ((System.in.read() & 15) == 0)
            b *= 10;
        System.out.println(a + b);
    }
}
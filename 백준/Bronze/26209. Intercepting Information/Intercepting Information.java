public class Main {

    public static void main(String[] args) throws Exception {
        for(int i =0 ; i < 8; i++)
            if(read() ==9) {
                System.out.println("F");
                return;
            }
        System.out.println("S");
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
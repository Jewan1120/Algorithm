public class Main {

    public static void main(String[] args) throws Exception {
        int[] score = { 6, 3, 2, 1, 2 };
        int s1 = 0, s2 = 0;
        for (int i = 0; i < 5; i++)
            s1 += score[i] * read();
        for (int i = 0; i < 5; i++)
            s2 += score[i] * read();
        System.out.println(s1 + " " + s2);
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
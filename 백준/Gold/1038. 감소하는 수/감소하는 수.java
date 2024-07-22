import java.util.ArrayList;

public class Main {

    static ArrayList<Long> al = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int n = read();
        for (int i = 0; i < 10; i++) {
            recursive(i, 1);
        }
        al.sort((o1, o2) -> o1.compareTo(o2));
        if (n < al.size())
            System.out.println(al.get(n));
        else
            System.out.println(-1);
    }

    private static void recursive(long m, int p) {
        if (p > 10)
            return;
        al.add(m);
        for (int i = 0; i < m % 10; i++) {
            recursive((m * 10) + i, p + 1);
        }
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
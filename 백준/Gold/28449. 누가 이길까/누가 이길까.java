import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] t1 = new int[n];
        int[] t2 = new int[m];
        for (int i = 0; i < n; i++)
            t1[i] = read();
        for (int i = 0; i < m; i++)
            t2[i] = read();
        Arrays.sort(t1);
        Arrays.sort(t2);
        long win = 0, lose = 0, draw = 0;
        int p = 0, d = 0;
        for (int i = 0; i < n; i++) {
            while (p < m && t1[i] > t2[p]) {
                p++;
                d = 0;
            }
            if (d == 0)
                while (p + d < m && t1[i] == t2[p + d])
                    d++;
            win += p;
            draw += d;
        }
        lose = ((long) n * m) - win - draw;
        System.out.println(win + " " + lose + " " + draw);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
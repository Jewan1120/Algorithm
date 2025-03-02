import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), w = 0;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
        for (int i = 0; i < n; i++) {
            w = read();
            ArrayList<Integer> al = new ArrayList<>(hs);
            for (int v : al) {
                if (v + w <= 40_000)
                    hs.add(v + w);
                if (v - w > 0)
                    hs.add(v - w);
                if (w - v > 0)
                    hs.add(w - v);
            }
        }
        StringBuilder sb = new StringBuilder();
        n = read();
        for (int i = 0; i < n; i++)
            sb.append(hs.contains(read()) ? 'Y' : 'N').append(' ');
        System.out.println(sb);
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
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), q = read();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 1; i < n + 1; i++)
            if (read() == 1) {
                ts.add(i);
                ts.add(i + n);
            }
        StringBuilder sb = new StringBuilder();
        int now = 1;
        while (q-- > 0) {
            int oper = read();
            int p;
            switch (oper) {
            case 1:
                p = read();
                if (ts.contains(p)) {
                    ts.remove(p);
                    ts.remove(p + n);
                } else {
                    ts.add(p);
                    ts.add(p + n);
                }
                break;
            case 2:
                p = read() % n;
                now += p;
                if (now > n)
                    now %= n;
                break;
            case 3:
                if (ts.isEmpty())
                    sb.append("-1\n");
                else if (ts.contains(now)) {
                    sb.append("0\n");
                } else
                    sb.append(ts.higher(now) - now).append("\n");
                break;
            }
        }
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
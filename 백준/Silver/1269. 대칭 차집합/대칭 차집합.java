import java.util.HashSet;
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        HashSet<Integer> hs = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            hs.add(read());
            cnt++;
        }
        for (int i = 0; i < m; i++) {
            if (hs.contains(read())) cnt--;
            else cnt++;
        }
        System.out.println(cnt);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            type[i] = read();
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = read();
            if (type[i] == 0) {
                dq.offerLast(x);
            }
        }
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int x = read();
            dq.offerFirst(x);
            sb.append(dq.pollLast()).append(" ");
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
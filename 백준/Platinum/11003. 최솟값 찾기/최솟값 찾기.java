import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), l = read();
        Deque<int[]> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int p = read();
            while (!dq.isEmpty() && dq.peekFirst()[1] <= i - l)
                dq.pollFirst();
            while (!dq.isEmpty() && dq.peekLast()[0] > p)
                dq.pollLast();
            dq.offerLast(new int[] { p, i });
            sb.append(dq.peekFirst()[0]).append(" ");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}
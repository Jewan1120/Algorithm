import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }
        StringBuilder sb = new StringBuilder("<");
        int cnt = 1;
        while (!dq.isEmpty()) {
            if (cnt % k == 0) {
                sb.append(dq.poll()).append(", ");
            } else {
                dq.offer(dq.poll());
            }
            cnt++;
        }
        sb.replace(sb.length()-2, sb.length(), ">");
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
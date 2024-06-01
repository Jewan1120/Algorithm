import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        Deque<Integer> dq = new ArrayDeque<>();
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            int num = read();
            if (num == cnt) {
                cnt++;
            } else {
                while (!dq.isEmpty() && dq.peekLast() == cnt) {
                    dq.pollLast();
                    cnt++;
                }
                dq.offerLast(num);
            }
        }
        while (!dq.isEmpty() && dq.peekLast() == cnt) {
            dq.pollLast();
            cnt++;
        }
        System.out.println(dq.size() == 0 ? "Nice" : "Sad");
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
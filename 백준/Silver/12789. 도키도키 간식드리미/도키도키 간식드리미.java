import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static Deque<Integer> dq = new ArrayDeque<>();
    static int cnt = 1;

    public static void main(String[] args) throws Exception {
        int n = read();
        for (int i = 1; i <= n; i++) {
            int num = read();
            if (num == cnt) {
                cnt++;
            } else {
                move();
                dq.offerLast(num);
            }
        }
        move();
        System.out.println(dq.size() == 0 ? "Nice" : "Sad");
    }

    private static void move() {
        while (!dq.isEmpty() && dq.peekLast() == cnt) {
            dq.pollLast();
            cnt++;
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if (c == 13) {
            System.in.read();
        }
        return n;
    }
}
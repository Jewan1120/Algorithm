import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (; n > 0; n--) {
            int oper = read();
            switch (oper) {
                case 1:
                    dq.offerFirst(read());
                    break;
                case 2:
                    dq.offerLast(read());
                    break;
                case 3:
                    sb.append(dq.isEmpty() ? "-1" : dq.pollFirst()).append("\n");
                    break;
                case 4:
                    sb.append(dq.isEmpty() ? "-1" : dq.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;
                case 6:
                    sb.append(dq.isEmpty() ? "1" : "0").append("\n");
                    break;
                case 7:
                    sb.append(dq.isEmpty() ? "-1" : dq.peekFirst()).append("\n");
                    break;
                case 8:
                    sb.append(dq.isEmpty() ? "-1" : dq.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
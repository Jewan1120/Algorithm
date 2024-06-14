import java.util.ArrayDeque;
import java.util.Deque;
public class Main {
    static Deque<Integer> doQue = new ArrayDeque<>();
    static Deque<Integer> suQue = new ArrayDeque<>();
    static Deque<Integer> doGnd = new ArrayDeque<>();
    static Deque<Integer> suGnd = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        for (int i = 0; i < n; i++) {
            doQue.offerLast(read());
            suQue.offerLast(read());
        }
        boolean turn = false;
        while (m-- > 0) {
            if (!turn)
                doGnd.offerLast(doQue.pollLast());
            else
                suGnd.offerLast(suQue.pollLast());
            if (doQue.isEmpty() || suQue.isEmpty()) break;
            judge();
            turn = !turn;
        }
        System.out.println(doQue.size() == suQue.size() ? "dosu" : doQue.size() > suQue.size() ? "do" : "su");
    }
    private static void judge() {
        if (!doGnd.isEmpty() && !suGnd.isEmpty() && doGnd.peekLast() + suGnd.peekLast() == 5) {
            while (!doGnd.isEmpty()) suQue.offerFirst(doGnd.pollFirst());
            while (!suGnd.isEmpty()) suQue.offerFirst(suGnd.pollFirst());
        }
        if ((!doGnd.isEmpty() && doGnd.peekLast() == 5) || (!suGnd.isEmpty() && suGnd.peekLast() == 5)) {
            while (!suGnd.isEmpty()) doQue.offerFirst(suGnd.pollFirst());
            while (!doGnd.isEmpty()) doQue.offerFirst(doGnd.pollFirst());
        }
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        PriorityQueue<Integer> boxQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++)
            boxQue.offer(read());
        int[] wishList = new int[m];
        for (int i = 0; i < m; i++)
            wishList[i] = read();
        boolean flg = false;
        for (int i = 0; i < m; i++) {
            int req = wishList[i];
            if (boxQue.isEmpty() || boxQue.peek() < req) {
                flg = true;
                break;
            }
            int gift = boxQue.poll();
            gift -= req;
            if (gift > 0)
                boxQue.offer(gift);
        }
        System.out.println(flg ? 0 : 1);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
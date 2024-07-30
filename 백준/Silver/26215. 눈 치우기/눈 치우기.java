import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        int n = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++)
            pq.add(read());
        int cnt = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (pq.isEmpty()) {
                cnt += a;
                break;
            }
            int b = pq.poll();
            cnt += b;
            pq.offer(a - b);
        }
        System.out.println(cnt > 1440 ? -1 : cnt);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
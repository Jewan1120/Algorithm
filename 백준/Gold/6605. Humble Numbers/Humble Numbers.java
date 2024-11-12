import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

    static final int INF = 2_000_000_000;

    public static void main(String[] args) throws Exception {
        int[] factors = { 2, 3, 5, 7 };
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        pq.add(1L);
        set.add(1L);
        while (arr.size() <= 5842) {
            long smallest = pq.poll();
            arr.add((int) smallest);
            for (int factor : factors) {
                long next = smallest * factor;
                if (next <= INF && !set.contains(next)) {
                    pq.add(next);
                    set.add(next);
                }
            }
        }
        int n = 0;
        StringBuilder sb = new StringBuilder();
        while ((n = read()) != 0) {
            long p = arr.get(n);
            sb.append("The ").append(n);
            if (n % 100 >= 11 && n % 100 <= 13) {
                sb.append("th ");
            } else if (n % 10 == 1) {
                sb.append("st ");
            } else if (n % 10 == 2) {
                sb.append("nd ");
            } else if (n % 10 == 3) {
                sb.append("rd ");
            } else {
                sb.append("th ");
            }
            sb.append("humble number is ").append(p).append(".\n");
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long p1 = Long.parseLong(st.nextToken());
        long p2 = Long.parseLong(st.nextToken());
        long p3 = Long.parseLong(st.nextToken());
        int i = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> hs = new HashSet<>();
        pq.offer(p1);
        pq.offer(p2);
        pq.offer(p3);
        hs.add(p1);
        hs.add(p2);
        hs.add(p3);

        long num = 0;

        for (int count = 0; count < i; count++) {
            num = pq.poll();
            if (!hs.contains(num * p1)) {
                pq.offer(num * p1);
                hs.add(num * p1);
            }
            if (!hs.contains(num * p2)) {
                pq.offer(num * p2);
                hs.add(num * p2);
            }
            if (!hs.contains(num * p3)) {
                pq.offer(num * p3);
                hs.add(num * p3);
            }
        }
        System.out.println(num);
    }
}
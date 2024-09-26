import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++)
            graph.get(read()).add(read());
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        distance[1] = 0;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            for (int next : graph.get(cur)) {
                if (distance[next] == -1) {
                    dq.offer(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }
        System.out.println(distance[n]);
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
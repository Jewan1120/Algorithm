import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] times = new int[n + 1], costs = new int[n + 1], indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            al.add(new ArrayList<>());
        for (int i = 1; i < n + 1; i++) {
            times[i] = read();
            int prev;
            while ((prev = read()) != -1) {
                al.get(prev).add(i);
                indegree[i]++;
            }
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++)
            if (indegree[i] == 0)
                dq.offer(i);
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            times[cur] += costs[cur];
            for (int next : al.get(cur)) {
                costs[next] = Math.max(costs[next], times[cur]);
                if (--indegree[next] == 0)
                    dq.offer(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++)
            sb.append(times[i]).append("\n");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}
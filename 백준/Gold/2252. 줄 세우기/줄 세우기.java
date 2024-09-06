import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int[] indegree = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            edges.add(new ArrayList<>());
        while (m-- > 0) {
            int s = read(), e = read();
            indegree[e]++;
            edges.get(s).add(e);
        }
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++)
            if (indegree[i] == 0)
                dq.offer(i);
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            sb.append(cur).append(" ");
            for (int v : edges.get(cur)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    dq.offer(v);
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
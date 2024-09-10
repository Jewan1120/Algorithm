import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), m = read();
        int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int k = read();
            int prev = read();
            for (int j = 1; j < k; j++) {
                int next = read();
                edges.get(prev).add(next);
                indegree[next]++;
                prev = next;
            }
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++)
            if (indegree[i] == 0)
                dq.offer(i);
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int u = dq.poll();
            n--;
            sb.append(u).append("\n");
            for (int v : edges.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    dq.offer(v);
            }
        }
        if (n == 0)
            System.out.println(sb);
        else
            System.out.println(0);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
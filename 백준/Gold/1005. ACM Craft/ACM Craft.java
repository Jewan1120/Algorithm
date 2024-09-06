import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read(), k = read();
            int[] arr = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = read();
            }
            int[] indegree = new int[n + 1];
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < n + 1; i++)
                edges.add(new ArrayList<>());
            for (int i = 0; i < k; i++) {
                int s = read(), e = read();
                edges.get(s).add(e);
                indegree[e]++;
            }
            int w = read();
            int[] time = new int[n + 1];
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 1; i < n + 1; i++) {
                time[i] = arr[i];
                if (indegree[i] == 0)
                    dq.offer(i);
            }
            while (!dq.isEmpty()) {
                int cur = dq.poll();
                for (int v : edges.get(cur)) {
                    time[v] = Math.max(time[v], time[cur] + arr[v]);
                    indegree[v]--;
                    if (indegree[v] == 0)
                        dq.offer(v);
                }
            }
            sb.append(time[w]).append("\n");
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
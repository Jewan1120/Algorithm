import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    static int n;
    static int[][] distance;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = read();
            distance = new int[n + 2][];
            for (int i = 0; i < n + 2; i++)
                distance[i] = new int[] { read(), read() };
            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++)
                graph.add(new ArrayList<>());
            for (int i = 0; i < n + 1; i++)
                for (int j = i + 1; j < n + 2; j++)
                    if (isMovable(distance[i], distance[j])) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
            if (isPossible())
                sb.append("happy\n");
            else
                sb.append("sad\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible() {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 2];
        dq.offer(0);
        visited[0] = true;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            if (cur == n + 1)
                return true;
            for (int next : graph.get(cur))
                if (!visited[next]) {
                    dq.offer(next);
                    visited[next] = true;
                }
        }
        return false;
    }

    private static boolean isMovable(int[] A, int[] B) {
        return Math.abs(A[0] - B[0]) + Math.abs(A[1] - B[1]) <= 1_000;
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
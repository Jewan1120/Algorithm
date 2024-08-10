import java.util.ArrayList;
import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] cost : costs) {
            int u = cost[0], v = cost[1], w = cost[2];
            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            if (visited[u[0]])
                continue;
            visited[u[0]] = true;
            answer += u[1];
            for (int[] v : graph.get(u[0])) {
                if (!visited[v[0]])
                    pq.offer(new int[] { v[0], v[1] });
            }
        }
        return answer;
    }
}
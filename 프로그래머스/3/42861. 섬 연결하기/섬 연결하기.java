import java.util.ArrayList;
import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int[][] costs) {
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++)
            edges.add(new ArrayList<>());
        for (int[] cost : costs) {
            int u = cost[0], v = cost[1], w = cost[2];
            edges.get(u).add(new int[] { v, w });
            edges.get(v).add(new int[] { u, w });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[n];
        pq.offer(new int[] { 0, 0 });
        int totalWeight = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]])
                continue;
            visited[cur[0]] = true;
            totalWeight += cur[1];
            for (int[] edge : edges.get(cur[0]))
                if (!visited[edge[0]]) {
                    pq.offer(edge);
                }
        }
        return totalWeight;
    }
}
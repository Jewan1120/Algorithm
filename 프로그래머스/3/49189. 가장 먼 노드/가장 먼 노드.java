import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        dq.offer(new int[] { 1, 1 });
        int cnt = 0, maxDepth = 1;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (visited[cur[0]])
                continue;
            visited[cur[0]] = true;
            if (maxDepth == cur[1])
                cnt++;
            else {
                maxDepth = cur[1];
                cnt = 1;
            }
            for (int v : graph.get(cur[0])) {
                dq.offer(new int[] { v, cur[1] + 1 });
            }
        }
        return cnt;
    }
}
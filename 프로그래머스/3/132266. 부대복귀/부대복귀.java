import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int[] answer = new int[sources.length];
        int[] dist = dijstra(graph, destination);
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
            if (answer[i] == Integer.MAX_VALUE)
                answer[i] = -1;
        }
        return answer;
    }
    
    public int[] dijstra(List<List<Integer>> graph, int destination) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[destination] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(destination);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (int next : graph.get(cur)) {
                if (dist[cur] + 1 < dist[next]) {
                    dist[next] = dist[cur] + 1;
                    pq.offer(next);
                }
            }
        }
        return dist;
    }
}
import java.util.ArrayList;
import java.util.PriorityQueue;
class Solution {
    
    class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++)
            edges.add(new ArrayList<>());
        for (int[] cost : costs) {
            edges.get(cost[0]).add(new Edge(cost[1], cost[2]));
            edges.get(cost[1]).add(new Edge(cost[0], cost[2]));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        boolean[] visited = new boolean[n];
        pq.offer(new Edge(0, 0));
        int cnt = 0;
        while (!pq.isEmpty() && cnt < n) {
            Edge cur = pq.poll();
            if (visited[cur.to])
                continue;
            visited[cur.to] = true;
            cnt++;
            answer += cur.weight;
            for (Edge edge : edges.get(cur.to)) {
                if (!visited[edge.to])
                    pq.offer(edge);
            }
        }
        return answer;
    }
}
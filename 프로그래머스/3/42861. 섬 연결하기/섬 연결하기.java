import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    
    class Edge implements Comparable<Edge> {
        int to;
        int weight;
        
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other){
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int weight = costs[i][2];
            graph.get(x).add(new Edge(y, weight));
            graph.get(y).add(new Edge(x, weight));
        }
        boolean[] inMST = new boolean[n];
        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.add(new Edge(0, 0));
        while(!que.isEmpty()){
            Edge cur = que.poll();
            int u = cur.to;
            if(inMST[u]) continue;
            
            inMST[u] = true;
            answer += cur.weight;
            
            for(Edge neighbor : graph.get(u)){
                int v = neighbor.to;
                int weight = neighbor.weight;
                if (!inMST[v]) {
                    que.add(new Edge(v, weight));
                }
            }
        }
        return answer;
    }   
}
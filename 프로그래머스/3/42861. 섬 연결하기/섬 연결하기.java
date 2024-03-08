import java.util.Arrays;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < costs.length; i++) {
            int rootX = find(parent, costs[i][0]);
            int rootY = find(parent, costs[i][1]);
            int weight = costs[i][2];
            if (rootX != rootY) {
                parent[rootX] = rootY;
                answer += weight;
            }
        }
        return answer;
    }
    
    public int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}
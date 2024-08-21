class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (computers[i][j] == 1)
                    union(i, j);
            }
        for (int i = 0; i < n; i++)
            if (find(i) == i)
                answer++;
        return answer; 
    }
    
    private void union(int v, int u) {
        int rootV = find(v);
        int rootU = find(u);
        if (rootV != rootU)
            parent[rootV] = rootU;
    }

    private int find(int v) {
        if (parent[v] != v)
            parent[v] = find(parent[v]);
        return parent[v];
    }
}
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int u = results[i][0], v = results[i][1];
            graph[u][v] = true;
        }
        for (int k = 1; k < n + 1; k++)
            for (int i = 1; i < n + 1; i++)
                for (int j = 1; j < n + 1; j++)
                    if (graph[i][k] && graph[k][j])
                        graph[i][j] = true;
        for (int i = 1; i < n + 1; i++) {
            boolean possible = true;
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    continue;
                if (!graph[i][j] && !graph[j][i]) {
                    possible = false;
                    break;
                }
            }
            if (possible)
                answer++;
        }
        return answer;
    }
}

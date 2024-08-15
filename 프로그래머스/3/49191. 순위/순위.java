class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = true;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
        next: for (int i = 1; i <= n; i++) {
            boolean canDetermine = true;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (!graph[i][j] && !graph[j][i]) {
                    continue next;
                }
            }
            answer++;
        }
        
        return answer;
    }
}

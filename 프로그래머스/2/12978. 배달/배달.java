class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[][] dis = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    dis[i][j] = 0;
                else
                    dis[i][j] = 500001;
            }
        }
        for (int[] town : road) {
            int s = town[0];
            int e = town[1];
            int k = town[2];
            if (dis[s][e] > k) {
                dis[s][e] = k;
                dis[e][s] = k;
            }
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dis[1][i] != 0 && dis[1][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}
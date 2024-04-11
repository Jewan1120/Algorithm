class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] damageGrid = new int[N + 1][M + 1];
        for (int[] info : skill) {
            if (info[0] == 1)
                info[5] *= -1;
            int r1 = info[1], c1 = info[2];
            int r2 = info[3] + 1, c2 = info[4] + 1;
            int damage = info[5];
            damageGrid[r1][c1] += damage;
            damageGrid[r1][c2] -= damage;
            damageGrid[r2][c1] -= damage;
            damageGrid[r2][c2] += damage;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                damageGrid[j + 1][i] += damageGrid[j][i];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                damageGrid[i][j + 1] += damageGrid[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + damageGrid[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }
}
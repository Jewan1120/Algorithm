class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][] newBoard = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int k = i; k <= i + 2; k++) {
                        for (int l = j; l <= j + 2; l++) {
                            newBoard[k][l] = 1;
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (newBoard[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
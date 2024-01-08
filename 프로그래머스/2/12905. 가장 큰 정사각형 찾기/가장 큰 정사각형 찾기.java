class Solution{
    public int solution(int[][] board){
        int answer = board[0][0];
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[0].length - 1; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (board[i][j + 1] != 0 && board[i + 1][j] != 0 && board[i + 1][j + 1] != 0) {
                    int n = Math.min(board[i][j], Math.min(board[i][j + 1], board[i + 1][j])) + 1;
                    board[i + 1][j + 1] = n;
                    if (answer < n) {
                        answer = n;
                    }
                }
            }
        }
        return answer * answer;
    }
}
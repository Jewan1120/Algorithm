import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Queue<boolean[][]> boardQue = new ArrayDeque<boolean[][]>();
        Queue<Integer> countQue = new ArrayDeque<Integer>();
        boardQue.add(new boolean[n][n]);
        countQue.add(0);
        while (!boardQue.isEmpty()) {
            boolean[][] board = boardQue.poll();
            int count = countQue.poll();
            for (int i = 0; i < n; i++) {
                if (!board[count][i]) {
                    boolean[][] tmpBoard = new boolean[n][n];
                    for (int j = 0; j < board.length; j++) {
                        tmpBoard[j] = board[j].clone();
                    }
                    if (count + 1 == n) {
                        answer++;
                        break;
                    }
                    for (int j = 1; j < n - count; j++) {
                        tmpBoard[count + j][i] = true;
                        if (0 <= i - j) {
                            tmpBoard[count + j][i - j] = true;
                        }
                        if (i + j < n) {
                            tmpBoard[count + j][i + j] = true;
                        }
                    }
                    boardQue.add(tmpBoard.clone());
                    countQue.add(count + 1);
                }
            }
        }
        return answer;
    }
}
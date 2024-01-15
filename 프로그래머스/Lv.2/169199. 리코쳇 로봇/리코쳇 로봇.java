import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] g = {};
        Queue<int[]> que = new ArrayDeque<int[]>();
        Queue<boolean[][]> chkQue = new ArrayDeque<>();
        Queue<Integer> cntQue = new ArrayDeque<>();
        chkQue.add(new boolean[board.length][board[0].length()]);
        cntQue.add(0);
        for (int i = 0; i < board.length; i++) {
            if (board[i].contains("R")) {
                que.add(new int[] {i, board[i].indexOf("R")});
            }
            if (board[i].contains("G")) {
                g = new int[] {i, board[i].indexOf("G")};
            }
        }
        move: while (!que.isEmpty()) {
            int[] r = que.poll();
            boolean[][] chk = chkQue.poll();
            int count = cntQue.poll();
            chk[r[0]][r[1]] = true;
            for (int i = 0; i < 4; i++) {
                int x = r[1];
                int y = r[0];
                while (0 <= x + dx[i] && x + dx[i] < board[0].length() && 0 <= y + dy[i]
                        && y + dy[i] < board.length && board[y + dy[i]].charAt(x + dx[i]) != 'D') {
                    x += dx[i];
                    y += dy[i];
                }
                if (board[y].charAt(x) == 'G') {
                    answer = count + 1;
                    break move;
                } else if (!chk[y][x]) {
                    que.add(new int[] {y, x});
                    chkQue.add(chk);
                    cntQue.add(count + 1);
                }
            }
        }
        return answer == 0 ? -1 : answer;
    }
}
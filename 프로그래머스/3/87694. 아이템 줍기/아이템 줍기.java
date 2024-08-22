import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    
    boolean[][] board = new boolean[102][102];
    int[] dy = { 1, -1, 0, 0 };
    int[] dx = { 0, 0, 1, -1 };
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2, y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2, y2 = rectangle[i][3] * 2;
            for (int y = y1; y <= y2; y++)
                for (int x = x1; x <= x2; x++)
                    board[y][x] = true;
        }
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2, y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2, y2 = rectangle[i][3] * 2;
            for (int y = y1 + 1; y <= y2 - 1; y++)
                for (int x = x1 + 1; x <= x2 - 1; x++)
                    board[y][x] = false;
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { characterY * 2, characterX * 2, 0 });
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            if (cur[0] == itemY * 2 && cur[1] == itemX * 2) {
                answer = cur[2] / 2;
                break;
            }
            board[cur[0]][cur[1]] = false;
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (board[y][x]) {
                    dq.offer(new int[] { y, x, cur[2] + 1 });
                }
            }
        }
        return answer;
    }
}
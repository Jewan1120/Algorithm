class Solution {
    
    static boolean[][] board;
    static int maxDepth = 0;
    static int cnt = 0;
    static int len = 0;
    
    public int solution(int n) {
        board = new boolean[n][n];
        maxDepth = n;
        len = n;
        recursive(0);
        return cnt;
    }
    
    private void recursive(int depth) {
        if (depth == maxDepth) {
            cnt++;
            return;
        }
        for (int i = 0; i < len; i++) {
            if (isPossible(depth, i)) {
                board[depth][i] = true;
                recursive(depth + 1);
                board[depth][i] = false;
            }
        }
    }

    private boolean isPossible(int depth, int x) {
        for (int i = 1; i <= depth; i++) {
            for (int j = -1; j <= 1; j++) {
                int ny = depth - i;
                int nx = x + j * i;
                if (0 <= ny && ny < len && 0 <= nx && nx < len && board[ny][nx])
                    return false;
            }
        }
        return true;
    }
}
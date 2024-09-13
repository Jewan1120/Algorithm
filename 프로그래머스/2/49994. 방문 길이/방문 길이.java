class Solution {
    boolean[][][] board = new boolean[11][11][4];
    int[] dy = { 1, -1, 0, 0 };
    int[] dx = { 0, 0, 1, -1 };
    char[] dirsArr;
    int area;
    
    public int solution(String dirs) {
        dirsArr = dirs.toCharArray();
        recursion(5, 5, 0);
        return area;
    }
    private void recursion(int y, int x, int depth) {
        if (depth == dirsArr.length)
            return;
        int to = 0, from = 1;
        if (dirsArr[depth] == 'D') {
            to = 1;
            from = 0;
        } else if (dirsArr[depth] == 'R') {
            to = 2;
            from = 3;
        } else if (dirsArr[depth] == 'L') {
            to = 3;
            from = 2;
        }
        int ny = y + dy[to], nx = x + dx[to];
        board[y][x][to] = true;
        if (isValid(ny, nx)) {
            if (!board[ny][nx][from])
                area++;
            board[ny][nx][from] = true;
            recursion(ny, nx, depth + 1);
        } else
            recursion(y, x, depth + 1);
    }

    private boolean isValid(int y, int x) {
        return 0 <= y && y < 11 && 0 <= x && x < 11;
    }
}
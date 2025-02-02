import java.util.ArrayList;

public class Main {

    static int n, m, minArea = Integer.MAX_VALUE;
    static ArrayList<int[]> cameras = new ArrayList<>();
    static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int p = read();
                if (p == 0)
                    continue;
                if (p == 6)
                    board[i][j] = p;
                else
                    cameras.add(new int[] { i, j, p });
            }
        recursive(0, board);
        System.out.println(minArea);
    }

    private static void recursive(int depth, int[][] board) {
        if (depth == cameras.size()) {
            minArea = Math.min(minArea, calArea(board));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[] camera = cameras.get(depth);
            if ((camera[2] == 2 && i > 1) || (camera[2] == 5 && i > 0))
                continue;
            int[][] nextBoard = placeCamera(board, camera, i);
            recursive(depth + 1, nextBoard);
        }
    }

    private static int[][] placeCamera(int[][] board, int[] camera, int dir) {
        int[][] nextBoard = new int[n][m];
        for (int i = 0; i < n; i++)
            nextBoard[i] = board[i].clone();
        int y = camera[0], x = camera[1], type = camera[2];
        goStraight(nextBoard, y, x, dir);
        if (type == 2) {
            goStraight(nextBoard, y, x, (dir + 2) % 4);
        } else if (type == 3) {
            goStraight(nextBoard, y, x, (dir + 1) % 4);
        } else if (type == 4) {
            goStraight(nextBoard, y, x, (dir + 1) % 4);
            goStraight(nextBoard, y, x, (dir + 2) % 4);
        } else if (type == 5) {
            goStraight(nextBoard, y, x, (dir + 1) % 4);
            goStraight(nextBoard, y, x, (dir + 2) % 4);
            goStraight(nextBoard, y, x, (dir + 3) % 4);
        }
        return nextBoard;
    }

    private static void goStraight(int[][] board, int y, int x, int dir) {
        board[y][x] = -1;
        int ny = y + dy[dir], nx = x + dx[dir];
        while (isValid(ny, nx) && board[ny][nx] != 6) {
            board[ny][nx] = -1;
            ny += dy[dir];
            nx += dx[dir];
        }
    }

    private static int calArea(int[][] board) {
        int area = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (board[i][j] == 0)
                    area++;
        return area;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
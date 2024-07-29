import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    static class Node {
        int y, x, c, t;

        Node(int y, int x, int c, int t) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.t = t;
        }
    }

    static int[][] board;
    static boolean[] colors;
    static int[][] locations;
    static ArrayList<boolean[]> colorList = new ArrayList<>();
    static ArrayList<int[]> locatonList = new ArrayList<>();
    static int h, w, r, g, max = 0;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        h = read();
        w = read();
        r = read();
        g = read();
        board = new int[h][w];
        colors = new boolean[r + g];
        locations = new int[r + g][2];
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                int p = read();
                board[i][j] = p;
                if (p == 2) {
                    locatonList.add(new int[] {i, j});
                }
            }
        makeColorList(0, 0);
        selectGround(0, 0);
        System.out.println(max);
    }

    private static void makeColorList(int depth, int p) {
        if (depth == g) {
            colorList.add(colors.clone());
            return;
        }
        for (int i = p; i < r + g; i++) {
            colors[i] = true;
            makeColorList(depth + 1, i + 1);
            colors[i] = false;
        }
    }

    private static void selectGround(int depth, int p) {
        if (depth == r + g) {
            for (int i = 0; i < colorList.size(); i++) {
                colors = colorList.get(i);
                max = Math.max(max, bfs());
            }
            return;
        }
        for (int i = p; i < locatonList.size(); i++) {
            locations[depth] = locatonList.get(i);
            selectGround(depth + 1, i + 1);
        }
    }

    private static int bfs() {
        int[][][] visited = new int[h][w][2];
        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < r + g; i++) {
            int y = locations[i][0], x = locations[i][1];
            int c = colors[i] ? 1 : 2;
            dq.offer(new Node(y, x, c, 0));
            visited[y][x] = new int[] {c, 0};
        }
        int cnt = 0;
        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            int c = cur.c;
            int t = cur.t + 1;
            if (visited[cur.y][cur.x][0] == 3)
                continue;
            for (int i = 0; i < 4; i++) {
                int y = cur.y + dy[i];
                int x = cur.x + dx[i];
                if (isValid(y, x)) {
                    int nc = visited[y][x][0];
                    int nt = visited[y][x][1];
                    if (nc == 0) {
                        dq.offer(new Node(y, x, c, t));
                        visited[y][x] = new int[] {c, t};
                    } else if (((c == 1 && nc == 2) || (c == 2 && nc == 1)) && t == nt) {
                        visited[y][x][0] = 3;
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w && board[y][x] != 0;
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
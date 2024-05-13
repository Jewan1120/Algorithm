import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    static int h;
    static int w;
    static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    static boolean[][] board;
    
    static class Node {
        int y;
        int x;
        int depth;
        boolean type;
        
        public Node(int y, int x, int depth, boolean type) {
            this.y = y;
            this.x = x;
            this.depth = depth;
            this.type = type;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        board = new boolean[h][w];
        int[] s = new int[2];
        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (line[j] == 'J') {
                    s = new int[] {i, j};
                } else if (line[j] == 'F') {
                    dq.offer(new Node(i, j, 0, false));
                } else if (line[j] == '.') {
                    board[i][j] = true;
                }
            }
        }
        dq.offer(new Node(s[0], s[1], 0, true));
        while (!dq.isEmpty()) {
            Node node = dq.poll();
            for (int i = 0; i < 4; i++) {
                int y = node.y + dy[i];
                int x = node.x + dx[i];
                if (!valid(y, x)) {
                    if (node.type) {
                        System.out.println(node.depth + 1);
                        return;
                    }
                } else if (board[y][x]) {
                    dq.offer(new Node(y, x, node.depth + 1, node.type));
                    board[y][x] = false;
                }
            } 
        }
        System.out.println("IMPOSSIBLE");
    }
    
    public static boolean valid(int y, int x) {
        if (0 <= y && y < h && 0 <= x && x < w) {
            return true;
        }
        return false;
    }
}
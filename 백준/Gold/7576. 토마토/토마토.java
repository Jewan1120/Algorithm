import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    
    static class Node {
        int y;
        int x;
        int time;
        
        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] board = new int[h][w];
        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };
        int cnt = 0;
        int totalTime = 0;
        Deque<Node> dq = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int p = Integer.parseInt(st.nextToken());
                if (p == 0) {
                    cnt++;
                } else {
                    if(p == 1) {
                        dq.add(new Node(i, j, 0));
                    }
                    board[i][j] = p;
                }
            }
        }
        while (!dq.isEmpty()) {
            Node node = dq.poll();
            int time = node.time;
            totalTime = Math.max(totalTime, time);
            for (int i = 0; i < 4; i++) {
                int y = node.y + dy[i];
                int x = node.x + dx[i];
                if (0 <= y && y < h && 0 <= x && x < w) {
                    if (board[y][x] == 0) {
                        board[y][x] = 1;
                        cnt--;
                        dq.add(new Node(y, x, time + 1));
                    }
                }
            }
        }
        System.out.println(cnt == 0 ? totalTime : -1);
        br.close();
    }
}
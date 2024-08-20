import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y;
        int x;
        long cost;

        Node(int y, int x, long cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            HashMap<Character, Integer> hm = new HashMap<>();
            hm.put('E', 0);
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                hm.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
            }
            int sy = 0, sx = 0;
            char[][] board = new char[h][w];
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = line.charAt(j);
                    if (board[i][j] == 'E') {
                        sy = i;
                        sx = j;
                    }
                }
            }
            long[][] dist = new long[h][w];
            for (int i = 0; i < h; i++)
                for (int j = 0; j < w; j++)
                    dist[i][j] = Long.MAX_VALUE;
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
            dist[sy][sx] = 0;
            pq.offer(new Node(sy, sx, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.cost > dist[cur.y][cur.x])
                    continue;
                for (int i = 0; i < 4; i++) {
                    int y = cur.y + dy[i];
                    int x = cur.x + dx[i];
                    if (0 <= y && y < h && 0 <= x && x < w) {
                        long nextCost = cur.cost + hm.get(board[y][x]);
                        if (nextCost < dist[y][x]) {
                            dist[y][x] = nextCost;
                            pq.offer(new Node(y, x, nextCost));
                        }
                    }
                }
            }
            long min = Long.MAX_VALUE;
            for (int i = 0; i < h; i++) {
                min = Math.min(min, dist[i][0]);
                min = Math.min(min, dist[i][w - 1]);
            }
            for (int j = 0; j < w; j++) {
                min = Math.min(min, dist[0][j]);
                min = Math.min(min, dist[h - 1][j]);
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}
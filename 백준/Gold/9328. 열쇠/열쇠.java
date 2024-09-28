import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int h, w;
    static int document;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] keys;
    static ArrayList<int[]> doors;

    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            visited = new boolean[h + 2][w + 2];
            board = new char[h + 2][w + 2];
            doors = new ArrayList<>();
            keys = new boolean[26];
            for (int i = 0; i < w + 2; i++) {
                board[0][i] = '.';
                board[h + 1][i] = '.';
            }
            for (int i = 1; i < h + 1; i++) {
                String line = br.readLine();
                board[i][0] = '.';
                board[i][w + 1] = '.';
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    if (c == '*')
                        visited[i][1 + j] = true;
                    board[i][1 + j] = c;
                }
            }
            String keyStr = br.readLine();
            if (!keyStr.equals("0"))
                for (int i = 0; i < keyStr.length(); i++)
                    keys[keyStr.charAt(i) - 'a'] = true;
            document = 0;
            Deque<int[]> dq = new ArrayDeque<>();
            dq.offer(new int[] { 0, 0 }); // 테두리
            visited[0][0] = true;
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();
                bfs(cur);
                for (int i = 0; i < doors.size(); i++) {
                    int[] door = doors.get(i);
                    if (keys[door[0]]) {
                        dq.offer(new int[] { door[1], door[2] });
                        doors.remove(i);
                    }
                }
            }
            sb.append(document).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int[] s) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(s);
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int y = cur[0] + dy[i];
                int x = cur[1] + dx[i];
                if (isValid(y, x) && !visited[y][x]) {
                    int c = board[y][x];
                    if ('A' <= c && c <= 'Z')
                        doors.add(new int[] { c - 'A', y, x });
                    else {
                        if ('a' <= c && c <= 'z')
                            keys[c - 'a'] = true;
                        else if (c == '$')
                            document++;
                        dq.offer(new int[] { y, x });
                    }
                    visited[y][x] = true;
                }
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return 0 <= y && y < h + 2 && 0 <= x && x < w + 2;
    }
}
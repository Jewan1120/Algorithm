import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    static ArrayList<ArrayList<ArrayList<Integer>>> board;
    static int[] bcArr;
    static int[] dy = { 0, 0, 1, 0, -1 }, dx = { 0, -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            board = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                board.add(new ArrayList<>());
                for (int j = 0; j <= 10; j++) {
                    board.get(i).add(new ArrayList<>());
                    board.get(i).get(j).add(0);
                }
            }
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken());
            int[] aArr = new int[m + 1], bArr = new int[m + 1];
            bcArr = new int[a + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < m + 1; i++)
                aArr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < m + 1; i++)
                bArr[i] = Integer.parseInt(st.nextToken());
            int bcY, bcX, bcC, bcP;
            for (int i = 1; i < a + 1; i++) {
                st = new StringTokenizer(br.readLine());
                bcY = Integer.parseInt(st.nextToken());
                bcX = Integer.parseInt(st.nextToken());
                bcC = Integer.parseInt(st.nextToken());
                bcP = Integer.parseInt(st.nextToken());
                setBC(i, bcY, bcX, bcC);
                bcArr[i] = bcP;
            }
            int aY = 1, aX = 1, bY = 10, bX = 10;
            int maxSum = 0;
            for (int i = 0; i < m + 1; i++) {
                aY += dy[aArr[i]];
                aX += dx[aArr[i]];
                bY += dy[bArr[i]];
                bX += dx[bArr[i]];
                maxSum += calculateValue(aY, aX, bY, bX);
            }
            sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
        }
        System.out.println(sb);
    }

    private static void setBC(int idx, int sy, int sx, int depth) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[11][11];
        dq.offer(new int[] { sy, sx });
        board.get(sy).get(sx).add(idx);
        visited[sy][sx] = true;
        while (depth-- > 0) {
            int size = dq.size();
            while (size-- > 0) {
                int[] cur = dq.poll();
                int y = cur[0], x = cur[1];
                for (int i = 1; i < 5; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if (isValid(ny, nx) && !visited[ny][nx]) {
                        dq.offer(new int[] { ny, nx });
                        board.get(ny).get(nx).add(idx);
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    private static int calculateValue(int aY, int aX, int bY, int bX) {
        ArrayList<Integer> aList = board.get(aY).get(aX);
        ArrayList<Integer> bList = board.get(bY).get(bX);
        int value = 0;
        for (int a : aList)
            for (int b : bList) {
                if (a == b)
                    value = Math.max(value, bcArr[a]);
                else
                    value = Math.max(value, bcArr[a] + bcArr[b]);
            }
        return value;
    }

    private static boolean isValid(int y, int x) {
        return 0 < y && y <= 10 && 0 < x && x <= 10;
    }
}

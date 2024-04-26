import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    int cnt = 1;
                    dq.add(new int[] {i, j});
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        board[cur[0]][cur[1]] = 0;
                        for (int k = 0; k < 4; k++) {
                            int y = cur[0] + dy[k];
                            int x = cur[1] + dx[k];
                            if (0 <= y && y < n && 0 <= x && x < n) {
                                if (board[y][x] == 1) {
                                    cnt++;
                                    board[y][x] = 0;
                                    dq.add(new int[] {y, x});
                                }
                            }
                        }
                    }
                    al.add(cnt);
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(al.size() + "\n");
        al.sort((o1, o2) -> o1 - o2);;
        for (int i : al) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}
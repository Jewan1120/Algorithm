import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][n];
        int[][] rb = new int[n][n];
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int[] color = new int[2];
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                switch (cArr[j]) {
                    case 'R':
                        rgb[i][j] = 0;
                        rb[i][j] = 0;
                        break;
                    case 'G':
                        rgb[i][j] = 1;
                        rb[i][j] = 0;
                        break;
                    case 'B':
                        rgb[i][j] = 2;
                        rb[i][j] = 2;
                        break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rgb[i][j] != -1) {
                    int c = rgb[i][j];
                    dq.add(new int[] {i, j});
                    color[0]++;
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        for (int k = 0; k < 4; k++) {
                            int y = cur[0] + dy[k];
                            int x = cur[1] + dx[k];
                            if (0 <= y && y < n && 0 <= x && x < n) {
                                if (rgb[y][x] == c) {
                                    dq.add(new int[] {y, x});
                                    rgb[y][x] = -1;
                                }
                            }
                        }
                    }
                }
                if (rb[i][j] != -1) {
                    int c = rb[i][j];
                    dq.add(new int[] {i, j});
                    color[1]++;
                    while (!dq.isEmpty()) {
                        int[] cur = dq.poll();
                        for (int k = 0; k < 4; k++) {
                            int y = cur[0] + dy[k];
                            int x = cur[1] + dx[k];
                            if (0 <= y && y < n && 0 <= x && x < n) {
                                if (c == 0 || c == 1) {
                                    if (rb[y][x] == 0 || rb[y][x] == 1) {
                                        dq.add(new int[] {y, x});
                                        rb[y][x] = -1;
                                    }
                                } else if (rb[y][x] == c) {
                                    dq.add(new int[] {y, x});
                                    rb[y][x] = -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("%d %d", color[0], color[1]);
        br.close();
    }
}
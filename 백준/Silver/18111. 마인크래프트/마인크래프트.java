import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int max = 0, min = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cnt = Integer.parseInt(st.nextToken());
                board[i][j] = cnt;
                max = Math.max(max, cnt);
                min = Math.min(min, cnt);
            }
        }
        int minTime = Integer.MAX_VALUE;
        int top = 0;
        for (int h = 0; h <= max; h++) {
            int time = 0;
            int blocks = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = board[i][j] - h;
                    if (diff > 0) {
                        time += diff * 2;
                        blocks += diff;
                    } else {
                        time += Math.abs(diff);
                        blocks -= Math.abs(diff);
                    }
                }
            }
            if (blocks >= 0 && time <= minTime) {
                minTime = time;
                top = h;
            }
        }
        System.out.println(minTime + " " + top);
    }
}
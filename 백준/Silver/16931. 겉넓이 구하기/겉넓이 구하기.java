import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int area = 2;
                for (int k = 0; k < 4; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (0 <= y && y < n && 0 <= x && x < m) {
                        if (board[i][j] > board[y][x]) {
                            area += board[i][j] - board[y][x];
                        }
                    } else {
                        area += board[i][j];
                    }
                }
                total += area;
            }
        }
        System.out.println(total);
    }
}
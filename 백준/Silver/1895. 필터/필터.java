import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    
    static int[][] board;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < r - 2; i++)
            for (int j = 0; j < c - 2; j++)
                if (filter(i, j) >= t)
                    cnt++;
        System.out.println(cnt);
    }
    
    private static int filter(int y, int x) {
        int[] arr = new int[9];
        int idx = 0;
        for (int i = y; i < y + 3; i++)
            for (int j = x; j < x + 3; j++)
                arr[idx++] = board[i][j];
        Arrays.sort(arr);
        return arr[4];
    }
}
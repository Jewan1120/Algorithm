import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++)
            board[i] = br.readLine().toCharArray();
        int stepNum = n * m / (k * k);
        int[] countList = new int[26];
        int totalRepaints = 0;
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {
                countList = new int[26];
                for (int i = 0; i < n; i += k) {
                    for (int j = 0; j < m; j += k) {
                        char t = board[i + x][j + y];
                        countList[t - 'A']++;
                    }
                }
                int maxTileNum = 0;
                char maxTile = 'A';
                for (int l = 0; l < 26; l++) {
                    if (countList[l] > maxTileNum) {
                        maxTileNum = countList[l];
                        maxTile = (char) (l + 'A');
                    }
                }
                totalRepaints += stepNum - maxTileNum;
                for (int i = 0; i < n; i += k) {
                    for (int j = 0; j < m; j += k) {
                        board[i + x][j + y] = maxTile;
                    }
                }
            }
        }
        System.out.println(totalRepaints);
        for (int i = 0; i < n; i++) {
            System.out.println(new String(board[i]));
        }
    }
}
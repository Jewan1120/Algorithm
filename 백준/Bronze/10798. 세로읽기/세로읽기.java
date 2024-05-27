import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[5][15];
        for (int i = 0; i < 5; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < cArr.length; j++) {
                board[i][j] = cArr[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[j][i] != 0) {
                    sb.append(board[j][i]);
                }
            }
        }
        System.out.println(sb);
    }
}
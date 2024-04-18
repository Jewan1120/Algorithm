import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int h = Integer.parseInt(info[0]);
        int w = Integer.parseInt(info[1]);
        String[] board = new String[h];
        for (int i = 0; i < h; i++) {
            board[i] = br.readLine();
        }
        String[] arr = {"BWBWBWBW", "WBWBWBWB"};
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= h - 8; i++) {
            for (int j = 0; j <= w - 8; j++) {
                int[] cnt = new int[2];
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (board[i + k].charAt(j + l) != arr[k % 2].charAt(l)) {
                            cnt[0]++;
                        }
                        if (board[i + k].charAt(j + l) != arr[(k + 1) % 2].charAt(l)) {
                            cnt[1]++;
                        }
                    }
                }
                result = Math.min(result, Math.min(cnt[0], cnt[1]));
            }
        }
        System.out.println(result);
    }
}
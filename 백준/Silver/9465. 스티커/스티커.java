import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (; t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 2; i <= n; i++) {
                arr[0][i] = Math.max(arr[0][i] + arr[1][i - 2], arr[0][i] + arr[1][i - 1]);
                arr[1][i] = Math.max(arr[1][i] + arr[0][i - 2], arr[1][i] + arr[0][i - 1]);
            }
            bw.write(Math.max(arr[0][n], arr[1][n]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
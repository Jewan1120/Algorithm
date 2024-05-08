import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = {Integer.parseInt(br.readLine())};
        int max = dp[0];
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[i + 1];
            for (int j = 0; j < i; j++) {
                temp[j] = Math.max(temp[j], dp[j]);
                temp[j + 1] = Math.max(temp[j + 1], dp[j]);
            }
            for (int j = 0; j <= i; j++) {
                temp[j] += Integer.parseInt(st.nextToken());
                max = Math.max(max, temp[j]);
            }
            dp = temp;
        }
        System.out.println(max);
        br.close();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (; N > 0; N--) {
            arr[N - 1] = Integer.parseInt(br.readLine());
        }
        int p = 0;
        int coins = 0;
        while (K > 0) {
            if (arr[p] <= K) {
                int cnt = K / arr[p];
                K -= cnt * arr[p];
                coins += cnt;
            }
            p++;
        }
        System.out.println(coins);
    }
}
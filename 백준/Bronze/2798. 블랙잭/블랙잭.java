import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] strArr = br.readLine().split(" ");
        br.close();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(cards);
        int result = -1;
        for (int i = 0; i < N - 2; i++) {
            int sum = cards[i];
            for (int j = i + 1; j < N - 1; j++) {
                if (sum > M / 3) break;
                sum += cards[j];
                for (int k = j + 1; k < N; k++) {
                    if (sum > M * 2 / 3) break;
                    sum += cards[k];
                    if (sum <= M && result < sum) result = sum;
                    sum -= cards[k];
                }
                sum -= cards[j];
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
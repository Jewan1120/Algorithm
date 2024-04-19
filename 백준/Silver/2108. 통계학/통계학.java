import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);
        int sum = 0;
        int prev = -4001;
        int most = 0;
        int cnt = 0;
        int[] mostArr = new int[2];
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (prev != arr[i]) {
                cnt = 0;
            }
            prev = arr[i];
            cnt++;
            if (cnt > most) {
                most = cnt;
                mostArr = new int[] {arr[i], -4001};
            } else if (cnt == most && mostArr[1] == -4001) {
                mostArr[1] = mostArr[0];
                mostArr[0] = arr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append((int) Math.round((double) sum / N)).append("\n");
        sb.append(arr[N / 2]).append("\n");
        sb.append(mostArr[0]).append("\n");
        sb.append((int) Math.abs(arr[N - 1] - arr[0])).append("\n");
        System.out.println(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((int) Math.round((double) sum / N) + "\n");
        bw.write(arr[N / 2] + "\n");
        bw.write(mostArr[0] + "\n");
        bw.write((int) Math.abs(arr[N - 1] - arr[0]) + "\n");
        bw.flush();
        bw.close();
    }
}
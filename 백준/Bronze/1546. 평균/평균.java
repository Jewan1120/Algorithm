import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        br.close();
        int max = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(strArr[i]);
            max = Math.max(max, score);
            sum += score;
        }
        float avg = (float) sum * 100 / N / max;
        bw.write(avg + "\n");
        bw.flush();
        bw.close();
    }
}
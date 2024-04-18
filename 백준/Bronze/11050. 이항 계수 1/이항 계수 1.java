import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        int c = 1;
        for (int i = N; i > K; i--) {
            c *= i;
        }
        for (int i = N - K; i > 0; i--) {
            c /= i;
        }
        bw.write(c + "\n");
        bw.flush();
        bw.close();
    }
}
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] prime = new boolean[1001];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(1001); i++) {
            if (prime[i] == true)
                continue;
            for (int j = i * 2; j < 1001; j += i) {
                prime[j] = true;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int answer = 0;
        String[] arr = br.readLine().split(" ");
        for (String str : arr) {
            int k = Integer.parseInt(str);
            if (!prime[k])
                answer++;
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
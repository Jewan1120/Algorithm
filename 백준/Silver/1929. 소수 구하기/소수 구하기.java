import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] prime = new boolean[1_000_001];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(1_000_001); i++) {
            if (prime[i] == true)
                continue;
            for (int j = i * 2; j < 1_000_001; j += i) {
                prime[j] = true;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (; s <= e; s++) {
            if (!prime[s]) {
                bw.write(s + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
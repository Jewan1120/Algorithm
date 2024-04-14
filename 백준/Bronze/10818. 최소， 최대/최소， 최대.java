import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = 1_000_000, max = -1_000_000;
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (n < min)
                min = n;
            if (n > max)
                max = n;
        }
        bw.write(String.format("%d %d", min, max));
        bw.flush();
        bw.close();
        br.close();
    }
}